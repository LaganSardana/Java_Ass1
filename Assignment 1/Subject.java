public class Subject {
    private String code;
    private String title;
    private int credits;
    private String school;

    public Subject(String code, String title, int credits, String school){
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
}
