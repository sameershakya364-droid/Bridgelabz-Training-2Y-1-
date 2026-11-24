package src.LInkList.Assignment;

import java.util.*;

public class Friends {
    static class User {int id,age;String name;Set<Integer> friends=new LinkedHashSet<>();User next;User(int i,String n,int a){id=i;name=n;age=a;}}
    static User head;static Scanner sc=new Scanner(System.in);
    static User find(int id){for(User p=head;p!=null;p=p.next)if(p.id==id)return p;return null;}
    static void addUser(){System.out.print("User ID: ");int id=sc.nextInt();sc.nextLine();if(find(id)!=null){System.out.println("ID exists.");return;}System.out.print("Name: ");String n=sc.nextLine();System.out.print("Age: ");int a=sc.nextInt();User x=new User(id,n,a);if(head==null)head=x;else{User p=head;while(p.next!=null)p=p.next;p.next=x;}System.out.println("User added.");}
    static void connect(boolean remove){System.out.print("First user ID: ");User a=find(sc.nextInt());System.out.print("Second user ID: ");User b=find(sc.nextInt());if(a==null||b==null||a==b){System.out.println("Enter two different existing users.");return;}if(remove){a.friends.remove(b.id);b.friends.remove(a.id);System.out.println("Connection removed if it existed.");}else{a.friends.add(b.id);b.friends.add(a.id);System.out.println("Friend connection added.");}}
    static void displayFriends(){System.out.print("User ID: ");User u=find(sc.nextInt());if(u==null){System.out.println("User not found.");return;}System.out.println("Friends of "+u.name+":");for(int id:u.friends){User f=find(id);if(f!=null)System.out.println(f.id+" - "+f.name);}}
    static void mutual(){System.out.print("First user ID: ");User a=find(sc.nextInt());System.out.print("Second user ID: ");User b=find(sc.nextInt());if(a==null||b==null){System.out.println("User not found.");return;}a.friends.retainAll(new HashSet<>(b.friends));System.out.println("Mutual friend IDs: "+a.friends); }
    static void search(){sc.nextLine();System.out.print("Search by 1 ID / 2 Name: ");int c=sc.nextInt();sc.nextLine();if(c==1){System.out.print("ID: ");User u=find(sc.nextInt());if(u!=null)show(u);else System.out.println("Not found.");}else{System.out.print("Name: ");String n=sc.nextLine();boolean f=false;for(User p=head;p!=null;p=p.next)if(p.name.equalsIgnoreCase(n)){show(p);f=true;}if(!f)System.out.println("Not found.");}}
    static void show(User u){System.out.printf("ID %d | %s | Age %d | Friends %d%n",u.id,u.name,u.age,u.friends.size());}
    static void counts(){for(User p=head;p!=null;p=p.next)show(p);}
    public static void main(String[] args){while(true){System.out.println("\\n1 Add user 2 Add friend connection 3 Remove friend connection 4 Mutual friends 5 Display friends 6 Search user 7 Friend count for each user 0 Exit");int c=sc.nextInt();switch(c){case 1:addUser();break;case 2:connect(false);break;case 3:connect(true);break;case 4:mutual();break;case 5:displayFriends();break;case 6:search();break;case 7:counts();break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
