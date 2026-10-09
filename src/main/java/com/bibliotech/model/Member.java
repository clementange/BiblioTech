package main.java.com.bibliotech.model;

public class Member extends Person{

    private MembershipLevel level;
    public Member(String name, String id, MembershipLevel level){
      super(name,id);
      this.level= level;
    }

    public MembershipLevel getLevel() {
        return level;
    }
    @Override
    public String toString(){
        return String.format("%s-%s",super.toString(), level);
    }
}
