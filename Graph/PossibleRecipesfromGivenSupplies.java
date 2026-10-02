package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PossibleRecipesfromGivenSupplies {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies){
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        
        for(int i=0; i<recipes.length; i++){
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());
            for (String item : ingredients.get(i)) {
                graph.putIfAbsent(item, new ArrayList<>());
                graph.get(item).add(recipe);
            }
        }

        Queue<String> q = new LinkedList<>();

        for(String supply : supplies){
            q.offer(supply);
        }

        List<String> res = new ArrayList<>();

        while(!q.isEmpty()){
            String curr = q.poll();
            
            if(indegree.containsKey(curr)){
                res.add(curr);
            }

            if(graph.containsKey(curr)){
                for(String recipe : graph.get(curr)){
                    indegree.put(recipe, indegree.get(recipe) - 1);
                    if(indegree.get(recipe) == 0){
                        q.offer(recipe);
                    }
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String recipes[] = {"bread","sandwich"};
        List<List<String>> ingredients = List.of(
            List.of("yeast", "flour"),
            List.of("bread", "meat")
        );
        String supplies[] = {"yeast","flour","meat"};

        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }
}
