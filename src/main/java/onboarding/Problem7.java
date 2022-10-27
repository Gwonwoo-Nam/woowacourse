package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
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
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friends = new ArrayList<>();
        HashMap<String, Integer> friend_score = new HashMap<String, Integer>();
        user_friends = find_user_friend(user, friends);

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
        for (String visitor : visitors){
            if (!user_friends.contains(visitor)) {
                update_values(friend_score, visitor, 1);
            }
        }

        List<String> keySetList = new ArrayList<>(friend_score.keySet());

        Collections.sort(keySetList, (o1, o2) -> (friend_score.get(o1).compareTo(friend_score.get(o2))));

        for (String item : friend_score.keySet())
        {
            answer.add(item);
        }
        return answer;
    }


}
