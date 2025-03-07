import javax.swing.*;
import java.util.Scanner;

public class LL {
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
            this.next=null;
        }

    }
    public void insertAtBeginning(int data)
    {Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
    }
    public void deletionAtBeginning()
    {
        if(head==null)
        {
            System.out.println("no nodes");
        }
        else {
            head=head.next;
        }
    }
    public void insertAtEnd(int data)
    {Node newnode=new Node(data);
        if(head==null)
        {
            head=newnode;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    public void deletionAtEnd()
    { if(head==null)
    {
        System.out.println("No nodes");
    }
       else if(head.next==null)
        {
            head=null;
        }
        else {
            Node temp=head;
            while(head.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    public void delAtPos(int pos)
    {
        if(pos<=0)
    {
        System.out.println("invalid position");
    }
        else if (head==null)
        {
            System.out.println("no nodes");
        }
        else if(pos==1)
        {
            head=head.next;
        }
        else
        { Node temp=head;
            for(int i=1;temp!=null&& i<pos-1;i++)
            {
                temp=temp.next;
            }
            if (temp == null || temp.next == null) {
                System.out.println("out of range");
                return;
            }
            temp.next=temp.next.next;
        }
    }
    public void insertionAtPos(int pos,int data)
    {Node newnode=new Node(data);
        if(pos<=0)
        {
            System.out.println("invalid position");

        }
        else if (pos == 1) {
            newnode.next = head;
            head = newnode;

        }
        else {
            Node temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }
   public  boolean  detectLoop()
   {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public void display() {
        if (head == null) {
            System.out.println("no nodes");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        LL obj=new LL();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("Choose operation");
            System.out.println("1.Insert at Beginning");
            System.out.println("2.Insert at End");
            System.out.println("3.Insert at Position");
            System.out.println("4.Deletion from Beginning");
            System.out.println("5.Deletion from End");
            System.out.println("6.Delete at Position");
            System.out.println("7.Detect Loop");
            System.out.println("8.Display LL");
            System.out.println();
            System.out.print("Enter choice");
            int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter value");
                int val1 = sc.nextInt();
                obj.insertAtBeginning(val1);
                break;
            case 2:
                System.out.print("Enter value");
                int val2 = sc.nextInt();
                obj.insertAtEnd(val2);
                break;
            case 3:
                System.out.print("Enter pos");
                int pos1 = sc.nextInt();
                System.out.print("Enter value");
                int val3 = sc.nextInt();
                obj.insertionAtPos(pos1,val3);
                break;
            case 4:
                obj.deletionAtBeginning();
                break;
            case 5:
                obj.deletionAtEnd();
                break;
            case 6:
                System.out.print("Enter pos");
                int pos2 = sc.nextInt();
                obj.delAtPos(pos2);
                break;
            case 7:
                if (obj.detectLoop()) {
                    System.out.println("Loop detected");
                } else {
                    System.out.println("No loop");
                }
                break;
            case 8:
                obj.display();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

}

