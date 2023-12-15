import java.util.Scanner;
class InterfaceofAtm{
    String name;
    String userName;
    String password;
    String accountNo;
    double balance=200000;
    int transactions=0;
    String transactionHistory="";

    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Name:");
        this.name=sc.nextLine();
        System.out.println("\n Enter Username:");
        this.userName=sc.nextLine();
        System.out.println("\nEnter the Password:");
        this.password=sc.nextLine();
        System.out.println("\nEnter your Account Number:");
        this.accountNo=sc.nextLine();
        System.out.println("\nRegistartion completed successfully1Kindly login to your account.");
    }
    public boolean login(){
        boolean isLogin=false;
        Scanner sc=new Scanner(System.in);
        while(!isLogin){
            System.out.print("\nEnter Username:");
            String username=sc.nextLine();
            if(username.equals(userName)){
                while(!isLogin){
                    System.out.print("\nEnter your password:");
                    String Password=sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLOgin successfull!");
                        isLogin=true;
                    }else 
                       System.out.println("\nIncorrect Password");
                }
            }else
               System.out.println("\nUsername not found");
        }
        return isLogin;
    }
    public void withdraw(){
        System.out.println("\nEnter the amount to be withdrawn:");
        Scanner sc=new Scanner(System.in);
        double amount=sc.nextDouble();
        try{
            if(balance>=amount){
                balance-=amount;
                System.out.println("\nWithdrawal successfull!");
                String str="Rs"+amount+"withdrawal\n";
                transactionHistory=transactionHistory.concat(str);
            }else
               System.out.println("\nInsufficient Balance.");
        }catch(Exception e){

        }
    }
    public void deposit(){
        System.out.println("\nEnter amount to deposit:");
        Scanner sc=new Scanner(System.in);
        double amount=sc.nextDouble();
        try{
            if(amount<=100000.00){
                transactions++;
                balance+=amount;
                System.out.println("\nDeposit sucessfull!");
                String str="Rs"+amount+"deposited\n";
                transactionHistory=transactionHistory.concat(str);
            }else
               System.out.println("\nLimit Exceeded!");
        }catch(Exception e){

        }
    }
    public void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter recepient name:");
        String recepient=sc.nextLine();
        System.out.println("\nEnter amount to be transferred:");
        double amount=sc.nextDouble();
        try{
            if(balance>=amount){
                if(amount<=50000.00){
                    transactions++;
                    balance-=amount;
                    System.out.println("Succefully transferred to"+recepient);
                    String str="Rs"+amount+"transferred to"+recepient+"\n";
                    transactionHistory=transactionHistory.concat(str);
                }else
                   System.out.println("\nSorry!Limit is 50000.00");
            }else
               System.out.println("\nInsufficient Balance.");
        }catch(Exception e){

        }
    }
    public void checkBalnce(){
        System.out.println("\nRs"+balance);
    }
    public void transHistory(){
        if(transactions==0)
           System.out.println("\nEmpty");
        else
           System.out.println("\n"+transactionHistory);
        }
    }

public class Task3 {
    public static int takeInput(int lmt){
        int input=0;
        boolean flag=false;
        while(!flag){
            try{
                Scanner sc=new Scanner(System.in);
                input=sc.nextInt();
                flag=true;
                if(flag && input>lmt || input<1){
                    System.out.println("Select the number between 1 to "+lmt);
                    flag=false;
                }

            }catch(Exception e){
                System.out.println("Enter integer vzlue only");
                flag=false;
            }
        }
        return input;

    }
    public static void main(String[] args){
        System.out.println("\nWELCOME TO ATM \n");
        System.out.println("1.Register\n 2.Exit");
        System.out.println("Enter your choice:");
        int choice=takeInput(2);
        if(choice==1){
            InterfaceofAtm b=new InterfaceofAtm();
            b.register();
            while(true){
                System.out.println("\n1.Login\n2.Exit");
                System.out.println("Enter your choice:");
                int ch=takeInput(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("\n\n WELCOME BACK!"+b.name+"\n\n");
                        boolean isFinished=false;
                        while(!isFinished){
                            System.out.println("\n1.Deposit\n 2.Withdraw\n3.Transfer\n4.Transation History\n5.Check Balance");
                            System.out.println("Enter your choice:");
                            int c=takeInput(6);
                            switch(c){
                                case 1:
                                    b.deposit();
                                    break;
                                case 2:
                                    b.withdraw();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.transHistory();
                                    break;
                                case 5:
                                    b.checkBalnce();
                                    break;
                                case 6:
                                    isFinished=true;
                                    break;
                                default:
                                    System.out.println("\nWrong choice");
                            }
                        }
                        
                    }
                }else
                   System.exit(0);
                
            }

        }

    }

    }
    

