package BusRes;

public class Bus {

    private int busNo;
    private boolean ac;
    private int capacity;

    private String isAc;

    Bus(int bn,boolean ac,int cap){
        this.busNo=bn;
        this.ac=ac;
        if(this.ac){
            isAc="Yes";
        }else{
            isAc="No";
        }
        this.capacity=cap;
    }


    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void displayBusInfo(){
        System.out.println("Bus number: "+busNo+"\nIs AC: "+isAc+"\nBus Capacity: "+capacity);
    }
}
