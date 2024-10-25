package com.leetcode.solution.leetcodesolutions.MediumQuestions;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : jayantakarmakar
 * @mailto : jayantakarmakar998@mail.com
 * @created : 25/10/24, Friday
 **/

@Slf4j
public class RemoveSubfolders {
    public static @NotNull List<String> removeSubfolders(String[] folder) {
        // Sort the folder list lexicographically
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        String currentParent = "";

        for (String f : folder) {
            // Check if the current folder is not a sub-folder of the current parent
            if (currentParent.isEmpty() || !f.startsWith(currentParent + "/")) {
                result.add(f);
                currentParent = f;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        log.info("Output : {}", removeSubfolders(folder));
    }
}


//    Example 1:
//
//    Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//    Output: ["/a","/c/d","/c/f"]
//    Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
