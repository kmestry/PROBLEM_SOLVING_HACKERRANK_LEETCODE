package com.leetcode;

public class MirrorReflectionNovChallenge {

    public int mirrorReflection(int p, int q) {

        int reflections = p;
        int extension = q;

        while (reflections % 2 == 0 && extension % 2 == 0) {
            reflections /= 2;
            extension /= 2;
        }

        if (extension % 2 == 0 && reflections % 2 != 0) return 0;
        if (extension % 2 != 0 && reflections % 2 == 0) return 2;
        if (extension % 2 != 0 && reflections % 2 != 0) return 1;

        return -1;
    }
}
