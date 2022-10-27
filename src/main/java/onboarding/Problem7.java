package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private static boolean check_user_length(String user){
        if (user.length() < 1 || user.length() > 30){
            return false;
        }
        return true;
    }
    private static boolean check_visitors_size(List<String> visitors){
        if (visitors.size() < 0 || visitors.size() > 10000){
            return false;
        }
        return true;
    }
    private static boolean check_friends_size(List<List<String>> friends){
        if (friends.size() < 1 || friends.size() > 10000){
            return false;
        }
        return true;
    }
    private static boolean is_in_friend_size(String friend_id) {
        if (friend_id.length() < 1 || friend_id.length() > 30)
            return false;
        return true;
    }
    private static boolean check_friends_element(List<List<String>> friends){
        for (List<String> relation : friends) {
            if (relation.size() != 2){
                return false;
            }
            if (is_in_friend_size(relation.get(0)) || is_in_friend_size(relation.get(1)))
                return false;
        }
        return true;
    }



    private static boolean check_exceptions(String user, List<List<String>> friends, List<String> visitors) {
        if (!check_user_length(user))
            return false;
        if (!check_visitors_size(visitors))
            return false;
        if (!check_friends_size(friends))
            return false;
        if (!check_friends_element(friends))
            return false;
        if (!check_user_alphabet(user))
            return false;
        return true;
    }
    private static List<String> find_user_friend(String user, List<List<String>> friends) {
        List<String> user_friend = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).get(0) == user){
                user_friend.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1) == user) {
                user_friend.add(friends.get(i).get(0));
            }
        }
        return (user_friend);
    }
    private static void update_values(HashMap<String, Integer> friend_score, String friends, int point) {
        int value;
        if (friend_score.containsKey(friends)) {
            value = friend_score.get(friends);
            friend_score.put(friends, value + point);
        }
        else
            friend_score.put(friends, point);
    }


    private static List<String> add_name_to_answer(HashMap<String, Integer> friend_score) {
        List<String> answer = new ArrayList<>();
        for (String item : friend_score.keySet())
        {
            answer.add(item);
        }
        return (answer);
    }

    private static void sort_by_score(HashMap<String, Integer> friend_score) {
        List<String> keySetList = new ArrayList<>(friend_score.keySet());
        Collections.sort(keySetList, (o1, o2) -> (friend_score.get(o1).compareTo(friend_score.get(o2))));
    }

    private static void update_relation_score(String user, List<List<String>> friends, List<String> user_friends, HashMap<String, Integer> friend_score) {
        for (List<String> relation : friends){
            for (String user_friend : user_friends){
                if (relation.get(0) == user_friend && relation.get(1) != user){
                    update_values(friend_score, relation.get(1), 10);
                }
                if (relation.get(1) == user_friend && relation.get(0) != user){
                    update_values(friend_score, relation.get(0), 10);
                }
            }
        }
    }
    private static void update_visitor_score(List<String> visitors, List<String> user_friends, HashMap<String, Integer> friend_score) {
        for (String visitor : visitors){
            if (!user_friends.contains(visitor)) {
                update_values(friend_score, visitor, 1);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        HashMap<String, Integer> friend_score = new HashMap<String, Integer>();
        if (check_exceptions(user, friends, visitors))
            return List.of("");
        user_friends = find_user_friend(user, friends);
        update_relation_score(user, friends, user_friends, friend_score);
        update_visitor_score(visitors, user_friends, friend_score);
        sort_by_score(friend_score);
        answer = add_name_to_answer(friend_score);
        return answer;
    }


}
