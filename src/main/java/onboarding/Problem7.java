package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> user_friend = new ArrayList<>();
        HashMap<String, Integer> friend_score = new HashMap<String, Integer>();
        int value = 0;
        user_friend = find_user_friend(user, friends);

        for (int i = 0; i < friends.size(); i++){
            for (int j = 0; j < user_friend.size(); j++){
                if (friends.get(i).get(0) == user_friend.get(j) && friends.get(i).get(1) != user){
                    if (friend_score.containsKey(friends.get(i).get(1))) {
                        value = friend_score.get(friends.get(i).get(1));
                        friend_score.put(friends.get(i).get(1), value + 10);
                    }
                    else
                        friend_score.put(friends.get(i).get(1), 10);
                }
                if (friends.get(i).get(1) == user_friend.get(j) && friends.get(i).get(0) != user){
                    if (friend_score.containsKey(friends.get(i).get(0))) {
                        value = friend_score.get(friends.get(i).get(0));
                        friend_score.put(friends.get(i).get(0), value + 10);
                    }
                    else
                        friend_score.put(friends.get(i).get(0), 10);
                }
            }
        }
        for (String visitor : visitors){
            if (!user_friend.contains(visitor)) {
                if (friend_score.containsKey(visitor)) {
                    value = friend_score.get(visitor);
                    friend_score.put(visitor, value + 1);
                } else
                    friend_score.put(visitor, 1);
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
}
