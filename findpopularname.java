
/**
 * Write a description of findpopularname here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import org.apache.commons.csv.*;
import edu.duke.*;
import java.lang.*;
import java.util.*;
import java.io.*;
public class findpopularname {
/*public int testpopularname(String name,int year,String gender)
{
    String filename="C:\\Users\\varda\\Downloads\\babyNames\\data\\yob"+year+".csv";
    FileResource f=new FileResource(filename);
    CSVParser p=f.getCSVParser(false);//when no header is given,use "false"
    int c=0;int rank=-1;
    int totalbirthsmale=0;int totalbirthsfemale=0;
    for(CSVRecord r:p)
    {
        String getname=r.get(0);
        String getgender=r.get(1);
        c+=1;
        if(getgender.equals("F"))
        {
            totalbirthsfemale+=Integer.parseInt(r.get(2));
        }
        else{
            totalbirthsmale+=Integer.parseInt(r.get(2));
        }
        if(getname.equals(name) && getgender.equals(gender))
        {
           rank=c;
          
        }
    }
    return rank;
}
*/
// TYPE 1 OF GETTING HIGHEST RANK OF NAME
public int testpopularname(String name,int year,String gender)
{
    String filename="C:\\Users\\varda\\Downloads\\babyNames\\data\\yob"+year+".csv";
    FileResource f=new FileResource(filename);
    CSVParser p=f.getCSVParser(false);//when no header is given,use "false"
    int cmale=0;int rankmale=-1;int cfemale=0;int rankfemale=-1;
    int totalbirthsmale=0;int totalbirthsfemale=0;
    for(CSVRecord r:p)
    {
        String getname=r.get(0);
        String getgender=r.get(1);
        
        if(getgender.equals("F"))
        {
            totalbirthsfemale+=Integer.parseInt(r.get(2));
        }
        else{
            totalbirthsmale+=Integer.parseInt(r.get(2));
        } 
        if(getgender.equals("F"))//increase counter when you get females
        {
            cfemale+=1;
            if(name.equals(getname) && gender.equals(getgender))//if a name is both male and female,then update only one counter based on the gender we need-the other counter should stay at -1
            {
               rankfemale=cfemale; 
        }
    }
    else
    {
        cmale+=1;
        if(name.equals(getname) && gender.equals(getgender))//if we want female,male counter remains at -1 and vice-versa
            {
               rankmale=cmale; 
        }
    
}
}
if(gender.equals("M"))
{
    return rankmale;}
    else{
        return rankfemale;}
    }
    // TYPE 2 OF GETTING HIGHEST NAME BY GETTING PARSER OBJECT DIRECTLY
    public int testpopularnameagain(String name,CSVParser p,String gender)
{
    
    int cmale=0;int rankmale=-1;int cfemale=0;int rankfemale=-1;
    int totalbirthsmale=0;int totalbirthsfemale=0;
    for(CSVRecord r:p)
    {
        String getname=r.get(0);
        String getgender=r.get(1);
        
        if(getgender.equals("F"))
        {
            totalbirthsfemale+=Integer.parseInt(r.get(2));
        }
        else{
            totalbirthsmale+=Integer.parseInt(r.get(2));
        } 
        if(getgender.equals("F"))//increase counter when you get females
        {
            cfemale+=1;
            if(name.equals(getname) && gender.equals(getgender))//if a name is both male and female,then update only one counter based on the gender we need-the other counter should stay at -1
            {
               rankfemale=cfemale; 
        }
    }
    else
    {
        cmale+=1;
        if(name.equals(getname) && gender.equals(getgender))//if we want female,male counter remains at -1 and vice-versa
            {
               rankmale=cmale; 
        }
    
}
}
if(gender.equals("M"))
{
    return rankmale;}
    else{
        return rankfemale;}
    }   
public String getName(int year,int rank,String gender)
{
    String filename="C:\\Users\\varda\\Downloads\\babyNames\\data\\yob"+year+".csv";
    FileResource f=new FileResource(filename);
    CSVParser p=f.getCSVParser(false);String namefromfile="";
    int c=0;
    for(CSVRecord r:p)
    {
        if((r.get(1)).equals(gender))
        {
            c+=1;
            if(c==rank)
            {
                namefromfile=r.get(0);
            }
        }
    }
    return namefromfile;
}
public void highestInManyYears(String name,String gender)
{
    DirectoryResource dr=new DirectoryResource();
    int c=0;
    String filename="";int maximumrank=100000000;
    int sum=0;
   
    for(File fl:dr.selectedFiles())//get file name of all files one at a time
    {
        c+=1;
      FileResource f=new FileResource(fl);
      CSVParser p=f.getCSVParser(false);
      int currentrank=testpopularnameagain(name,p,gender);
    
      sum+=currentrank;
      
      if(currentrank<=maximumrank)
      {
          maximumrank=currentrank;
         filename=fl.getName();
        }
    }
    System.out.println(filename);
    System.out.println(sum/c);
}
// TYPE 3 -GET SUM OF ALL HIGHER NAMES AT SAME TIME WHEN FINDING RANK OF GIVEN NAME
   public int testpopularnameagainagain(String name,CSVParser p,String gender)
{
    
    int cmale=0;int rankmale=-1;int cfemale=0;int rankfemale=-1;
    int totalbirthsmale=0;int totalbirthsfemale=0;
    for(CSVRecord r:p)
    {
        String getname=r.get(0);
        String getgender=r.get(1);
        
        /* if(getgender.equals("F"))
        {
            totalbirthsfemale+=Integer.parseInt(r.get(2));
        }
        else{
            totalbirthsmale+=Integer.parseInt(r.get(2));
        }  */
        if(getgender.equals("F"))//increase counter when you get females
        {
            cfemale+=1;
            
            if(name.equals(getname) && gender.equals(getgender))//if a name is both male and female,then update only one counter based on the gender we need-the other counter should stay at -1
            {
               rankfemale=cfemale; 
               break;
        }
        totalbirthsfemale+=Integer.parseInt(r.get(2));//we added it after break statement so that our name's count is not added to the sum
    }
    else
    {
        cmale+=1;
        if(name.equals(getname) && gender.equals(getgender))//if we want female,male counter remains at -1 and vice-versa
            {
               rankmale=cmale; 
               break;
        }
    totalbirthsmale+=Integer.parseInt(r.get(2));
}
}
if(gender.equals("M"))
{
    return totalbirthsmale;}
    else{
        return totalbirthsfemale;}
    }   

public void getTotalBirthsRankedHigher(String name,String gender)
{
    FileResource f=new FileResource();
    CSVParser p=f.getCSVParser(false);
   int highernumber=testpopularnameagainagain(name,p,gender); 
   System.out.println(highernumber);
}
    
public void whatIsNameInYear(String name,int year,int newyear,String gender)
{
    int getinitialrank=testpopularname(name,year,gender);
    String getfinalname=getName(newyear,getinitialrank,gender);
    System.out.println(getfinalname);
}

}
