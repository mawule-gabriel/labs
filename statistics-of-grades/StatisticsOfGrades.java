import java.util.Scanner;

public class StatisticsOfGrades {
    private int[] scores;
    private int[] stats;

    public GradeStatistics(int numStudents) {
        scores = new int[numStudents];
        stats = new int[5]; // stats[0] = 0-20, stats[1] = 21-40, stats[2] = 41-60, stats[3] = 61-80, stats[4] = 81-100
    }

    public void initializeScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the grades for " + scores.length + " students:");

        for (int i = 0; i < scores.length; i++) {
            System.out.print("Score for student " + (i + 1) + ": ");
            while(!scanner.hasNextInt()){
                System.out.println("Please enter a valid value (0 - 100");
                scanner.next();
            }
            scores[i] = scanner.nextInt();
        }
    }

    public int getMaximumGrade() {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public int getMinimumGrade() {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public void calculateStats() {
        // Initialize the stats array to 0 for each range
        for (int i = 0; i < stats.length; i++) {
            stats[i] = 0;
        }

        // Calculate stats for each range
        for (int score : scores) {
            if (score >= 0 && score <= 20) {
                stats[0]++; // Grades from 0 to 20
            } else if (score >= 21 && score <= 40) {
                stats[1]++; // Grades from 21 to 40
            } else if (score >= 41 && score <= 60) {
                stats[2]++; // Grades from 41 to 60
            } else if (score >= 61 && score <= 80) {
                stats[3]++; // Grades from 61 to 80
            } else if (score >= 81 && score <= 100) {
                stats[4]++; // Grades from 81 to 100
            }
        }
    }

    public int[] getStats() {
        return stats;
    }
}
