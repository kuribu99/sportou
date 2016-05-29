package sports2u.com.sportou;

import java.util.ArrayList;

/**
 * Created by Kong My on 29/5/2016.
 */
public class Coach {

    private final int imageID;
    private final String name;
    private final String shortDescription;
    private final String sportsType;
    private final String longDescription;
    private final String location;
    private final String sportExperience;
    private final String coachExperience;
    private final String studentExperience;
    private final String oneCoach;
    private final String groupCoach;
    private final double price;
    private final double rating;

    public Coach(int imageID, String name, String shortDescription, String sportsType,
                 String longDescription, String location,
                 String sportExperience, String coachExperience, String studentExperience,
                 String oneCoach, String groupCoach, double price, double rating) {

        this.imageID = imageID;
        this.name = name;
        this.shortDescription = shortDescription;
        this.sportsType = sportsType;
        this.longDescription = longDescription;
        this.location = location;
        this.sportExperience = sportExperience;
        this.coachExperience = coachExperience;
        this.studentExperience = studentExperience;
        this.oneCoach = oneCoach;
        this.groupCoach = groupCoach;
        this.price = price;
        this.rating = rating;
    }

    public int getImageID() { return imageID; }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getSportsType() {
        return sportsType;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getLocation() {
        return location;
    }

    public String getSportExperience() {
        return sportExperience;
    }

    public String getCoachExperience() {
        return coachExperience;
    }

    public String getStudentExperience() {
        return studentExperience;
    }

    public String getOneCoach() {
        return oneCoach;
    }

    public String getGroupCoach() {
        return groupCoach;
    }

    public double getPrice() { return price; }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> asStringArray() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(String.valueOf(imageID));
        arr.add(name);
        arr.add(shortDescription);
        arr.add(sportsType);
        arr.add(longDescription);
        arr.add(location);
        arr.add(sportExperience);
        arr.add(coachExperience);
        arr.add(studentExperience);
        arr.add(oneCoach);
        arr.add(groupCoach);
        arr.add(String.valueOf(price));
        arr.add(String.valueOf(rating));
        return arr;
    }

    public static Coach fromStringArray(ArrayList<String> list) {
        return new Coach(
                Integer.parseInt(list.get(0)),
                list.get(1), list.get(2), list.get(3),
                list.get(4), list.get(5), list.get(6),
                list.get(7), list.get(8), list.get(9),
                list.get(10),
                Double.parseDouble(list.get(11)),
                Double.parseDouble(list.get(12)));
    }

}
