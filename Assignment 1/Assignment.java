public class Assignment {
    private String code;
    private int number; 
    private String dueDate; 
    private int totalWorth;

    Assignment(String code, int number, String dueDate, int totalWorth){
        this.code = code;
        this.number = number;
        this.dueDate = dueDate;
        this.totalWorth = totalWorth;
    }


    public String getCode(){
        return code;
    }

    public int getNumber(){
        return number;
    }

    public String toString(){
        return ("Subject code: "+code+"\nAssignment number: "+number+"\nDue date: "+dueDate+"\nTotal Worth: "+totalWorth);
    }


}
