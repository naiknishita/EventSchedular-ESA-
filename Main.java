//Author: Nishita Naik
//Seat No: 24P0320029
//title: Event Scheduling (hackfest, infofest)
//description: in this system a user can view the events and add add the events in the syatem.
//while adding the user can not add the event time slot which is already filled, this will avoid the overlapping of evemnts"

import java.util.*;

//class for main Events which host sub events
class EventHost{
    String HostName;
    String StartDate;

    //constructor
    public EventHost( String HostName) {
        this.HostName = HostName;
    }

    //getter and setters
    public String getHostName() {
        return HostName;
    }

    public void setHostName(String HostName) {
        this.HostName = HostName;
    }

}

//class for sub events
class Event extends EventHost{
    String EventName;
    int EventDate;
    int TimeSlot;

        //constructor
    public Event( String HostName, String eventName, int eventDate, int timeSlot) {
        super(HostName);
        EventName = eventName;
        EventDate = eventDate;
        TimeSlot = timeSlot;
    }

    //displays the event info
    public String toString() {
        return "InfoEvent: "+EventName +"\nHostedBy: "+HostName +"\ndate: "+ EventDate+"th Dec\ntime: "+ TimeSlot +"\n";
    }

}

// a generic class for participants
class Participant<P>{
    P id;
    int age;
    String eventP;

    //generic constructor
    public Participant(P id, int age, String event) {
        this.id = id;
        this.age = age;
        this.eventP = event;
    }
    //method to print the participant information
    public String toString() {
        return "Participant: "+ id +"\nAge: "+age+ "\nEvent: "+eventP+"\n";
    }

}


//main class
public class Main {
    static List<Event> evI = new ArrayList<>();
    static List<Event> evH = new ArrayList<>();
    static List<Participant> PartList = new ArrayList<>();

    public static void main(String[] args) {

        //List Data Structure for an events
        evI.add(new Event("info","inaugration", 12, 1));
        evH.add(new Event("info","inaugration", 12, 1));
        evH.add(new Event("info","inaugration", 14, 2));

        System.out.println("Event Scheduler foe sub events");
        int ch;
        Scanner sc =new Scanner(System.in);

        do{
            System.out.println("------Menu-----");
            System.out.println("1.list Events");
            System.out.println("2.Enter Event");
            System.out.println("3.list of participanrs");
            System.out.println("4.Enter participant");
            System.out.println("5.Exit");
            System.out.println("enter Your Choice");
            ch = sc.nextInt();

            Scanner sc2 = new Scanner(System.in);
            int date,ts;
            String evname,host;

            switch (ch){

                case 1:
                    System.out.println("-------Infofest Events---------\n");
                    for (Event e: evI) {
                        System.out.println(e);
                    }
                    System.out.println("-----Hackfest Events----------\n");
                    for (Event e: evH) {
                        System.out.println(e);
                    }

                    break;
                case 2:
                    try{

                        System.out.println("enter host:(Info/Hack)");
                        host=sc2.nextLine();
                        System.out.println("enter event name:");
                        evname=sc2.nextLine();
                        System.out.println("enter date:(12,13 or 14)");
                        date=sc.nextInt();
                        System.out.println("1.10am-12noon\n2.2pm-3pm\n3.3pm-5pm\n4.6pm-7pm\n5.12noon-12noon");
                        System.out.println("enter time slot");

                        ts=sc.nextInt();

                        for (Event e: evH) {
                            if(e.EventDate==date && e.TimeSlot==ts) {
                                System.out.println("time slot already ready filled: ");
                            }
                        }


                        if(host.equals("Info")){
                            evI.add(new Event(host,evname,date,ts));
                        }else if(host.equals("Hack")){
                            evH.add(new Event(host,evname,date,ts));
                        }else {
                            System.out.println("no such Event Host");
                        }
                    } catch (Exception e) {
                        System.out.println("exception occurred:"+ e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;



                case 3:
                    System.out.println("---------Participant List----------\n");
                    for (Participant e: PartList) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    String id,evt;
                    int a;
                    System.out.println("enter ur id");
                    id = sc2.nextLine();
                    System.out.println("enter age:");
                    try {
                        a= sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("enter an integer value");
                        break;
                    }
                    System.out.println("enter event name:");
                    evt=sc2.nextLine();
                    PartList.add(new Participant<>(id,a,evt));

                    break;

                case 5:
                    System.out.println("Exiting--------");


                default:
                    System.out.println("enter valid output");
            }

        }while(ch!=5);


    }
}