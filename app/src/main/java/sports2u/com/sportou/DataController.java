package sports2u.com.sportou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kong My on 28/5/2016.
 */
public class DataController {

    private static DataController instance;

    public static DataController getInstance() {
        if(instance == null)
            instance = new DataController();
        return instance;
    }

    public DataController() {
        isLoggedIn = false;
    }

    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoginStatus(boolean status) {
        isLoggedIn = status;
    }

    public List<Coach> getFilteredCoaches(String filter, String type, String location) {
        List<Coach> coachList = getCoaches();
        if(!(type == null  || type.isEmpty() || type.equals("Any sports"))) {
            for(int i = coachList.size() - 1; i >= 0; i--) {
                if(!coachList.get(i).getSportsType().equals(type))
                    coachList.remove(i);
            }
        }
        if(!(location == null  || location.isEmpty() || location.equals("Any locations"))) {
            for(int i = coachList.size() - 1; i >= 0; i--) {
                if(!coachList.get(i).getLocation().equals(location))
                    coachList.remove(i);
            }
        }

        if(filter.equals("rating")) {
            Collections.sort(coachList, new Comparator<Coach>() {
                @Override
                public int compare(Coach coach, Coach otherCoach) {
                    return -1 * Double.compare(coach.getRating(), otherCoach.getRating());
                }
            });
        }
        else if(filter.equals("distance")) {
            // No need to sort by now
        }
        else if(filter.equals("price")) {
            Collections.sort(coachList, new Comparator<Coach>() {
                @Override
                public int compare(Coach coach, Coach otherCoach) {
                    return -1 * Double.compare(coach.getPrice(), otherCoach.getPrice());
                }
            });
        }
        return coachList;
    }

    public static String[] getLocations() {
        return new String[] {
                "Any locations",
                "Ampang",
                "Bukit Jalil",
                "Cheras",
                "Damansara",
                "iCity",
                "Petaling Jaya",
                "Subang Jaya",
                "Seremban",
                "Shah Alam",
                "Klang",
                "Kuala Lumpur"
        };
    }

    public static String[] getSports() {
        return new String[] {
                "Any sports",
                "Badminton",
                "Football",
                "Taekwondo",
                "Tai Chi",
                "Swimming",
                "Squash",
                "Basketball",
                "Diving"
        };
    }

    public List<Coach> getCoaches() {
        List<Coach> coachList = new ArrayList<>();

        coachList.add(new Coach(
                R.drawable.james_bond, "James Bond", "A godlike badminton player", "Badminton",
                "Expert badminton player\nSmack = 300km/h", "Subang Jaya",
                "Playing since at of 3", "Coached for 10 years and having more than 100 student", "Not affiliated with Lee",
                "RM100 per session (2 hour)", "RM80 per session (2 hour, 3 students)",
                100, 4.9
        ));

        coachList.add(new Coach(
                R.drawable.lee, "Lee Chang Wai", "Casual football player", "Football",
                "Just a football player", "Cheras",
                "Playing since at of 13", "New coach", "Not affiliated with Lee",
                "RM50 per session (2 hour)", "RM20 per session (1 hour, 9 students)",
                50, 3.5
        ));

        coachList.add(new Coach(
                R.drawable.teo, "Elaine Teo", "DSmart Taekwondo Centre", "Taekwondo",
                "HP: 012-6018205\nAddress: A-2-12, The Plaza, Jalan Wan Kadir", "Damansara",
                "Taekwondo black belt", "More than 5 years of teaching", "Malaysia Taekwondo Championship Jury",
                "RM20 per session (4 hour)", "RM300 per session (4 hour, 25 students)",
                20, 4
        ));

        return coachList;
    }
}
