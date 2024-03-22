public class Subject {
    private String code;
    private String title;
    private int credits;
    private String school;

    public void setSubject(String code, String title, int credits, String school){
        this.code = code;
        this.title = title;
        this.credits = credits;
        this. school = school;
    }

    public String getCode(){
        return this.code;
    }

    public String toString(){
        return ("Subject code: "+code+"\nSubject Title: "+title+"\nCredits: "+credits+"\nOffered by: "+school);
    }
    // public static void main(String[] args) {
    //     Subject obj1 = new Subject();
    //     obj1.setSubject("csit213", "galbasics", 8, "Lagansschoolofliterature");
    //     String code123 = obj1.toString();
    //     System.out.println(code123);
    // }
}
