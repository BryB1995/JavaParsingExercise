   /**  
   Constuctor for food class
   Bryce Baker
   */



import java.util.*;
public class Food implements Comparable<Food>, Comparator<Food>
{
   
    public String name;
    public int count;
     Food(){}
Food(int newCount, String newName)
    {
        count = newCount;
        name = newName;
    
    }
    //Getters
    public int getCount()
    {return count;}
    
    public String getName()
    {return name;}
    //Setters
    public void setName(String name)
    {
this.name = name;
}
//Manage count
public void setCount(int count)
{
    this.count = count;
}
//compare
public int compareTo(Food f1)
{
return (this.name).compareTo(f1.name);    
}
//comparator
public int compare(Food f1, Food f2)
{
    return f1.count - f2.count;
}
    }




