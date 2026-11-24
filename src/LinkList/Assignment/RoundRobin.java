package src.LInkList.Assignment;

import java.util.*;

public class RoundRobin {
    static class Process {int id,burst,remaining,priority,completion;Process next;Process(int i,int b,int p){id=i;burst=b;remaining=b;priority=p;}}
    static Process head,tail;static Scanner sc=new Scanner(System.in);
    static void add(){System.out.print("Process ID: ");int id=sc.nextInt();if(find(id)!=null){System.out.println("ID exists.");return;}System.out.print("Burst time: ");int b=sc.nextInt();System.out.print("Priority: ");int p=sc.nextInt();if(b<=0){System.out.println("Burst time must be positive.");return;}Process x=new Process(id,b,p);if(head==null){head=tail=x;x.next=x;}else{x.next=head;tail.next=x;tail=x;}}
    static Process find(int id){if(head==null)return null;Process p=head;do{if(p.id==id)return p;p=p.next;}while(p!=head);return null;}
    static void display(){if(head==null){System.out.println("No active processes.");return;}Process p=head;do{System.out.printf("P%d remaining=%d priority=%d -> ",p.id,p.remaining,p.priority);p=p.next;}while(p!=head);System.out.println("(back to head)");}
    static void remove(Process target){if(head==null)return;Process p=head,prev=tail;do{if(p==target){if(p==head)head=head.next;if(p==tail)tail=prev;if(p==prev){head=tail=null;}else{prev.next=p.next;tail.next=head;}return;}prev=p;p=p.next;}while(p!=head);}
    static void simulate(){if(head==null){System.out.println("No processes.");return;}System.out.print("Time quantum: ");int q=sc.nextInt();if(q<=0){System.out.println("Quantum must be positive.");return;}
        int count=0;Process p=head;do{count++;p=p.next;}while(p!=head);int[] ids=new int[count],bursts=new int[count],completion=new int[count];int k=0;p=head;do{ids[k]=p.id;bursts[k]=p.burst;k++;p=p.next;}while(p!=head);
        int time=0,remaining=count;while(remaining>0){p=head;if(p==null)break;do{Process next=p.next;p.remaining-=Math.min(q,p.remaining);time+=Math.min(q,p.remaining+Math.min(q,p.remaining));if(p.remaining==0){for(int i=0;i<count;i++)if(ids[i]==p.id)completion[i]=time;remove(p);remaining--;if(head!=null)head=next;}else{head=next;}p=head;break;}while(false);System.out.print("After scheduling slice(s): ");display();}
        double wt=0,tat=0;System.out.println("Process | Burst | Completion | Waiting | Turnaround");for(int i=0;i<count;i++){int turn=completion[i],wait=turn-bursts[i];wt+=wait;tat+=turn;System.out.printf("P%d | %d | %d | %d | %d%n",ids[i],bursts[i],completion[i],wait,turn);}System.out.printf("Average waiting time: %.2f%nAverage turnaround time: %.2f%n",wt/count,tat/count);
    }
    public static void main(String[] args){while(true){System.out.println("\\n1 Add process 2 Display queue 3 Run Round Robin 0 Exit");int c=sc.nextInt();switch(c){case 1:add();break;case 2:display();break;case 3:simulate();break;case 0:return;default:System.out.println("Invalid choice.");}}}
}
