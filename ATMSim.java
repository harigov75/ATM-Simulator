import java.util.ArrayList;
import java.util.Scanner;

public class ATMSim {
    int id, balance;
    String name, password;

    ATMSim(int id, String password, int balance, String name) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int check;
        ArrayList<Integer> idList = new ArrayList<Integer>();
        ArrayList<ATMSim> accountList = new ArrayList<ATMSim>();
        int ch;
        while (true) {

            System.out.println("************WELCOME***********");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit amount");
            System.out.println("4. Withdraw amount");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            ch = sc.nextInt();
            if(ch==1){
                check = create(idList, accountList);
                if (check == 0) {
                    System.out.println("Try again.");
                    
                } else {
                    System.out.println("Created successfully.");
                    
                }
            }

            else if(ch==2){
                int tempID;
                String tempPass;
                System.out.println("Enter your id: ");
                tempID = sc.nextInt();
                System.out.println("Enter your password: ");
                tempPass = sc.next();
                if (idList.contains(tempID)) {
                    
                    for (ATMSim i : accountList) {
                        
                        if (tempID == i.id) {
                            
                            if (i.password.equals(tempPass)) {
                                System.out.println("checking....");
                                System.out.println("The balance is: " + i.balance);
                                
                            }else {
                                System.out.println("Wrong password.");
                                
                            }
                        } 
                    }

                } else {
                    System.out.println("Account does not exist.");
                    
                }
            }
            else if(ch==3){
                    int dep,tempID;
                    String tempPass;
                    System.out.println("Enter your id: ");
                    tempID = sc.nextInt();
                    System.out.println("Enter your password: ");
                    tempPass = sc.next();
                    if (idList.contains(tempID)) {
                        for (ATMSim i : accountList) {
                            if (tempID == i.id) {
                                if (i.password.equals(tempPass)) {
                                    System.out.println("Enter the amount to deposit: ");
                                    dep = sc.nextInt();
                                    i.balance += dep;
                                    System.out.println("Amount deposited. New balance: " + i.balance);
                                    
                                } else {
                                    System.out.println("Wrong password.");
                                    
                                }

                            }
                        }

                    } else {
                        System.out.println("Account does not exist.");
                        break;
                    }
            }
            else if(ch==4){

                int wdr,tempID;
                String tempPass;
                    System.out.println("Enter your id: ");
                    tempID = sc.nextInt();
                    System.out.println("Enter your password: ");
                    tempPass = sc.next();
                    if (idList.contains(tempID)) {
                        for (ATMSim i : accountList) {
                            if (tempID == i.id) {
                                if (i.password.equals(tempPass)) {
                                    System.out.println("Enter the amount to withdraw: ");
                                    wdr = sc.nextInt();
                                    i.balance -= wdr;
                                    System.out.println("Amount withdrawn. New balance: " + i.balance);
                                    
                                } else {
                                    System.out.println("Wrong password.");
                                }
                            }
                        }

                    } else {
                        System.out.println("Account does not exist.");
                        
                    }

            }
            else if(ch==5){
                sc.close();
                    System.exit(0);
                    
            }
            else{
                System.out.println("Invalid option");
                    
        }
    }

    }

    static int create(ArrayList<Integer> idList, ArrayList<ATMSim> accountList) {
        Scanner sc = new Scanner(System.in);
        int tempID, balance = 0;
        String tempName, tempPass;
        System.out.println("Create Account ID: ");
        tempID = sc.nextInt();
        if (idList.contains(tempID)) {
            System.out.println("Account already exists.");

            return 0;
        }
        idList.add(tempID);
        System.out.println("Enter name: ");
        tempName = sc.next();
        while (true) {
            System.out.println("Create password (only 4 characters): ");
            tempPass = sc.next();
            if (tempPass.length() == 4) {
                break;
            } else {
                System.out.println("Invalid password. Try again.");
                continue;
            }

        }
        ATMSim e = new ATMSim(tempID, tempPass, balance, tempName);
        accountList.add(e);

        return 1;

    }

}
