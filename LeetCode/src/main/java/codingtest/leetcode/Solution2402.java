package codingtest.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
        Rooms rooms = new Rooms(n);

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] meeting : meetings) {
            rooms.reserve(meeting);
        }

        return rooms.maximumReservedRoom();
    }

    class Room {
        int count = 0;
        int startTIme = Integer.MAX_VALUE;
        int endTime = 0;
        int number;

        public Room(int number) {
            this.number = number;
        }

        public int update(int[] meeting) {
            count++;
            if(endTime <= meeting[0]) {
                endTime = meeting[1];
            } else {
                endTime = endTime - meeting[0] + meeting[1];
            }

            startTIme = Math.min(startTIme, meeting[0]);

            return 0;
        }
    }

    private class Rooms {
        Room[] rooms;

        public Rooms(int n) {
            rooms = new Room[n];
            for (int i = 0; i < n; i++) {
                rooms[i] = new Room(i);
            }
        }

        public void reserve(int[] meeting) {
            int roomNum = -1;
            for (Room room : rooms) {
                if(meeting[0] >= room.endTime) {
                    roomNum = room.number;
                    break;
                }

                if(meeting[1] < room.startTIme) {
                    roomNum = room.number;
                    break;
                }
            }

            if(roomNum == -1) {
                roomNum = getMinRoomNum();
            }

            rooms[roomNum].update(meeting);
        }

        private int getMinRoomNum() {
            int minTime = Integer.MAX_VALUE;
            int roomNum = 0;
            for (Room room : rooms) {
                if(minTime > room.endTime) {
                    minTime = room.endTime;
                    roomNum = room.number;
                }
            }
            return roomNum;
        }

        public int maximumReservedRoom() {
            int max = Integer.MIN_VALUE;
            int roomNum = Integer.MAX_VALUE;
            for (Room room : rooms) {
                if(max < room.count) {
                    max = room.count;
                    roomNum = room.number;
                } else if (max == room.count){
                    roomNum = Math.min(roomNum, room.number);
                }
            }

            return roomNum;
        }
    }
}
