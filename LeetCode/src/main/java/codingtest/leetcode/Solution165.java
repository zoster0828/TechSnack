package codingtest.leetcode;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        Version versionOne = parse(version1);
        Version versionTwo = parse(version2);

        return versionOne.compare(versionTwo);
    }

    private Version parse(String version1) {
        return new Version(version1.split("\\."));
    }

    private class Version {
        int[] depth;

        public Version(String[] split) {
            depth = new int[split.length];

            for (int i = 0; i < split.length; i++) {
                depth[i] = Integer.parseInt(split[i]);
            }
        }

        public int compare(Version versionTwo) {
            int i = 0;
            while(i < Math.min(this.depth.length, versionTwo.depth.length)) {
                if(this.depth[i] > versionTwo.depth[i]) return 1;
                else if(this.depth[i] < versionTwo.depth[i]) return -1;
                i++;
            }

            for(;i < depth.length ; i++) {
                if(depth[i] != 0) return 1;
            }

            for(;i < versionTwo.depth.length ; i++) {
                if(versionTwo.depth[i] != 0) return -1;
            }

            return 0;
        }
    }
}
