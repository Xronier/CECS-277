public class Education implements Cloneable {
    String degree;
    String major;
    int research;

    public Education() {
        degree = "";
        major = "";
        research = 0;
    }

    public Education(String degree, String major, int research) {
        this.degree = degree;
        this.major = major;
        this.research = research;
    }

    // Setters
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setResearch(int research) {
        this.research = research;
    }

    // Getters
    public String getDegree() {
        return degree;
    }

    public String getMajor() {
        return major;
    }

    public int getResearch() {
        return research;
    }

    public Object clone() throws CloneNotSupportedException {
        Education edu = (Education)super.clone();
        edu.setMajor(major);
        edu.setDegree(degree);
        edu.setResearch(research);
        return edu;
    }
}
