import java.util.InputMismatchException;
import java.util.Scanner;

public class Boot {
    public static void main(String[] args) {
        String [] Pages = {"a","b","c","d","e","f","g","h","o","j","k","l","m","n","l","o","p"};
        int size = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input the quantity of pages(max = 17): ");
            size = scanner.nextInt();
        }catch (InputMismatchException exception){
            System.out.println("The thing, that you have just inputed is not a number");
            return;
        }

        if(size>17)
        {
            System.out.println("Число страниц должно быть меньше 17");
        }
        else{
            int [] using = new int[size];
            double  rand = 0;
            for(int i=0;i<size;i++)
            {

                using[i]= (int) Math.round(Math.random());

            }
            while (true)
            {
                int choose2 = 0;
                try{
                    System.out.println("1-Read page"+'\n'+"2-Find page block to free"+'\n'+
                            "3-Print status"+'\n'+"4-Exit Programm");
                    choose2 = scanner.nextInt();
                }
                catch (InputMismatchException exception)
                {
                    System.out.println("Thing what you had just wrote is not a number");
                    return;
                }
                boolean DobbieIsFree= true;
                switch (choose2)
                {
                    case 3:
                        System.out.println("Номер страницы|Название страницы|Давность пользования");
                        for (int i =0;i<size;i++)
                        {
                            System.out.println("     "+i+"       |        "+Pages[i]+"       |      "+using[i]);
                        }
                        break;
                    case 1:
                        System.out.println("Выберите название страницы, которая обратится к памяти: ");
                        String access = scanner.next();
                        for (int i = 0;i<size;i++)
                        {
                            using[i]+=1;
                            if(Pages[i].equals(access))
                            {
                               using[i]=0;
                            }
                        }
                        break;
                    case 2:
                        int max = 0,counter= 0 ;
                        int replace = 0;
                        for(int i =0;i<size;i++)
                        {
                            if(using[i]>max)
                            {
                                max=using[i];
                                counter=i;
                            }

                        }
                        System.out.println("Выберите номер операции, которую вы хотите добавить в список ");
                        for(int i =size;i<Pages.length;i++)
                        {
                            System.out.println(i+"-"+Pages[i]);
                        }
                        try{
                            replace = scanner.nextInt();
                        }catch (InputMismatchException exception )
                        {
                            System.out.println("Not a number");
                            return;
                        }

                        using[counter]= 0;
                        Pages[counter]=Pages[replace];
                        break;
                    case 4:
                        DobbieIsFree = false;
                }
                if(DobbieIsFree ==false) {
                    break;
                }
            }


        }
    }
}
