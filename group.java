
package group;

import user.usercontroller;
import java.util.ArrayList;
import java.util.List;
public interface group {
   
    //user User;
    
    public void AddMember(List<usercontroller> members,String GroupName,String kindofmember);
    public void removemember(String UserName,String GroupName);
    public void joingroup(usercontroller User);
    public group searchgroups(String groupname);
   
}
