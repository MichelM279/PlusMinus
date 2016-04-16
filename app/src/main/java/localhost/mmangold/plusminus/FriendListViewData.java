package localhost.mmangold.plusminus;

public class FriendListViewData {
    private String friend="";
    private int dept=0;

    // Setters
    public void setFriend(String _friend){
        this.friend = _friend;
    }
    public void setDept(int _dept){
        this.dept = _dept;
    }

    // Getters
    public String getFriend(){
        return this.friend;
    }
    public int getDept(){
        return this.dept;
    }
}
