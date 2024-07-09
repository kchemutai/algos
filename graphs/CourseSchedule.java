package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    static public boolean canFinish(int numCourses, int[][] prerequisites) {
        // HashmMap to store courses and prerequisites in a hash map
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();

        // create courses and their prerequisites
        for (int i = 0; i < numCourses; i++) {
            prerequisitesMap.put(i, new ArrayList<>());
        }

        // add pre-riquisites
        for (int[] prerequisite : prerequisites) {
            // get the Map Equivalent and the pre-requisite course
            prerequisitesMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        // create a set of visited courses to store prerequisite courses we have seen
        Set<Integer> visitedCourses = new HashSet<>();

        // loop through the courses to handle cases where courses don't have
        // prerequisites ie not connected
        for (int i = 0; i < numCourses; i++) {
            if (!bfs(i, prerequisitesMap, visitedCourses))
                return false;
        }
        return true;
    }

    static boolean bfs(int course, Map<Integer, List<Integer>> prerequisitesMap, Set<Integer> visitedCourses) {
        List<Integer> prerequisites = prerequisitesMap.get(course);
        if (prerequisites == null) {
            prerequisitesMap.put(course, new ArrayList<>());
        }
        // check if it has no prerequisites
        if (prerequisites == null)
            return true;

        // check if it has already been recorded in the prerequisites set(avoid the
        // loop)
        if (visitedCourses.contains(course))
            return false;

        // add the course to the visited courses
        visitedCourses.add(course);

        for (int prerequisite : prerequisites) {
            if (!bfs(prerequisite, prerequisitesMap, visitedCourses))
                return false;
        }

        visitedCourses.remove(course);
        prerequisitesMap.put(course, new ArrayList<>());

        return true;
    }

    public static void main(String[] args) {
        // should return false
        int[][] courses = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(2, courses));

    }
}