package Banking2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank
{

    String name;
    public Bank(String bankname)
    {
        this.name=bankname;
    }

    public static List<Client> ClList=new ArrayList<>();
    static ArrayList<Account> AcList = new ArrayList<>();

    public void addcl()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking2/Persons.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Person: ");
            String pcnic = sc.nextLine();
            int i=1;
            while(i<stores.length())
            {
                int pe=11*i-6;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Customer{,Name,"+spl[pe-3],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+3]+",}");
                        Client c = new Client(p);
                        c.addtofile();
                        System.out.println("Person is Added as Customer/Client Successfully! ");
                        System.out.println(p);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Person Found!");
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
    public void addac()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking2/customerss.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Client: ");
            String pcnic = sc.nextLine();
            int i=1;
            while(i<stores.length())
            {
                int pe=8*i-4;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Account{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        Client c = new Client(p);
                        System.out.println("Enter Amount: ");
                        float amuent=sc.nextFloat();
                        Account acac=new Account(amuent,c);
                        acac.addacounttofile();
                        System.out.println("Client's Account has been created Successfully!");
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Customer Found on this CNIC!");
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }


    void DepositInFile()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking2/Accounts.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Account: ");
            String mok=sc.nextLine();
            System.out.println("Enter Account ID: ");
            String pcnic = sc.nextLine();
            float oldamount;
            float newamount;
            float updatedamount;
            int i=1;
            while(i<stores.length())
            {
                int pe=10*i-2;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        oldamount= Float.parseFloat(spl[pe+1]);
                        System.out.println("Enter Deposit Amount: ");
                        newamount=sc.nextFloat();
                        updatedamount=oldamount+newamount;
                        spl[pe+1]= String.valueOf(updatedamount);

                        System.out.println("The Money Has been deposited ");
                        break;
                    }
                    else {
                        i++;

                    }

                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Account Found!");
                    break;
                }

            }
            try {
                PrintWriter writer = new PrintWriter("src/Banking2/Accounts.txt");
                writer.print("");
// other operations
                writer.close();
                int nemeq;
                int Cneq;
                int numbereq;
                int balanceeq;
                float blanacer;
                for (int itr=1;itr<spl.length;itr++)
                {
                    nemeq=10*itr-8;
                    Cneq=10*itr-6;
                    numbereq=10*itr-4;
                    balanceeq=10*itr-1;
                    Person p = new Person("Account{,Name,"+spl[nemeq],",CNIC:,"+spl[Cneq],",Number: ,"+spl[numbereq]+",}");
                    Client c = new Client(p);
                    blanacer= Float.parseFloat(spl[balanceeq]);
                    Account acac=new Account(blanacer,c);
                    acac.depositspecial();

                }

            }catch (ArrayIndexOutOfBoundsException exp)
            {
                System.out.println("No Such Customer Found on this CNIC!");
            }
            System.out.println(spl[20]);


        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

    void WithdrawFromFile()
    {
        {
            try
            {
                Scanner sc=new Scanner(System.in);
                File readperso=new File("src/Banking2/Accounts.txt");
                Scanner rsc=new Scanner(readperso);
                String stores="";
                while(rsc.hasNextLine())
                {
                    String readedpersons = rsc.nextLine();
                    stores =stores+ readedpersons;
                }
                String spl[]=stores.split(",");
                System.out.println("Enter CNIC of Account: ");
                String mok=sc.nextLine();
                System.out.println("Enter Account ID: ");
                String pcnic = sc.nextLine();
                float oldamount;
                float newamount;
                float updatedamount;
                int i=1;
                while(i<stores.length())
                {
                    int pe=10*i-2;
                    try {
                        if (pcnic.compareTo(spl[pe]) == 0)
                        {
                            oldamount= Float.parseFloat(spl[pe+1]);
                            System.out.println("Enter Withdraw Amount: ");
                            newamount=sc.nextFloat();
                            updatedamount=oldamount-newamount;
                            spl[pe+1]= String.valueOf(updatedamount);

                            System.out.println("The Money Has been Withdrawn");
                            break;
                        }
                        else {
                            i++;

                        }

                    }catch (ArrayIndexOutOfBoundsException exp)
                    {
                        System.out.println("No Such Account Found!(Task Done)");
                        break;
                    }

                }
                try {
                    PrintWriter writer = new PrintWriter("src/Banking2/Accounts.txt");
                    writer.print("");
// other operations
                    writer.close();
                    int nemeq;
                    int Cneq;
                    int numbereq;
                    int balanceeq;
                    float blanacer;
                    for (int itr=1;itr<spl.length;itr++)
                    {
                        nemeq=10*itr-8;
                        Cneq=10*itr-6;
                        numbereq=10*itr-4;
                        balanceeq=10*itr-1;
                        Person p = new Person("Account{,Name,"+spl[nemeq],",CNIC:,"+spl[Cneq],",Number: ,"+spl[numbereq]+",}");
                        Client c = new Client(p);
                        blanacer= Float.parseFloat(spl[balanceeq]);
                        Account acac=new Account(blanacer,c);
                        acac.depositspecial();

                    }

                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("Done!");
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
    }

    void DisplayClientInfo()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking2/customerss.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Client to View Info: ");
            String pcnic = sc.nextLine();
            int i=1;
            while(i<stores.length())
            {
                int pe=8*i-4;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Customer{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        System.out.println(p);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Person Found!");
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }


    void DisplayAccountInfo()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking2/Accounts.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Accounts to View Info: ");
            String pcnic = sc.nextLine();
            int i=1;
            while(i<stores.length())
            {
                int pe=10*i-6;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Account{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        System.out.println(p+"ID:"+spl[pe+4]+","+"Ammount:"+spl[pe+5]);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Person Found!");
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    Client addClient(Person p)
    {
        Client c = new Client(p);
        return c;
    }
    Account addAccount(float amount , Client c)
    {
        Account accc=new Account(amount,c);
        return accc;

    }
    Boolean removeClient(String id)
    {
        boolean del=true;
        for (Client client : ClList)
        {
            if ((client.ID).compareTo(id) == 0)
            {
                ClList.remove(client);
                return true;

            }
        }return false;
    }


    float sum=0;
    float totalAmount()
    {
        for (Client client:ClList){
            for (Account account:client.AcoList){
                sum += account.amount();
            }
        }
        return sum;
    }

    Account searchAccount(String id)
    {
        for (Account account : AcList)
        {
            if (account.getNumber().compareTo(id)==0)
            {
                return account;
            }

        }
        return null;
    }

    Client searchCustomerDetail(String CNIC)
    {
        for (Client cln : ClList)
        {
            if (cln.persondetails.getCNIC().equals(CNIC))
            {
                return cln;
            }

        }
        return null;
    }
    public String toString()
    {
        String disp = "";
        for (Client client :ClList)
        {
            disp += ("\n-------------\n");
            disp += (client +"\n\n");
            for (Account account: client.AcoList)
            {
                disp += account+"\n------\n";
            }
            disp += ("\n\n");
        }
        return disp;
    }



}
