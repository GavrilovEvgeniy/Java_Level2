package level2.lessonNumber1;

public class Main {

    public static class Human implements Moving {

        int MaxRun = 2000;
        float MaxJump = 2F;

        @Override
        public boolean run(int length) {
            if (MaxRun >= length) {
                System.out.println("Человек пробежал " + length + " метров.");
                return true;
            } else
            {
                System.out.println("Человек не смог пробежать " + length + " метров.");
                return false;
            }
        }

        @Override
        public boolean jump(float height) {
            if (MaxJump >= height) {
                System.out.println("Человек прыгнул на  " + height + " метров.");
                return true;
            } else
            {
                System.out.println("Человек не смог прыгнуть на " + height + " метров.");
                return false;
            }

        }
    }

    public static class Cat implements Moving {

        int MaxRun = 400;
        float MaxJump = 3F;

        @Override
        public boolean run(int length) {
            if (MaxRun >= length) {
                System.out.println("Кошка пробежала " + length + " метров.");
                return true;
            } else {
                System.out.println("Кошка не смогла пробежать " + length + " метров.");
                return false;
            }
        }

        @Override
        public boolean jump(float height) {
            if (MaxJump >= height) {
                System.out.println("Кошка прыгнула на  " + height + " метров.");
                return true;
            } else
            {
                System.out.println("Кошка не смогла прыгнуть на " + height + " метров.");
                return false;
            }
        }
    }

    public static class Robot implements Moving {

        int MaxRun = 50000;
        float MaxJump = 20F;

        @Override
        public boolean run(int length) {
            if (MaxRun >= length) {
                System.out.println("Робот пробежал " + length + " метров.");
                return true;
            } else
            {
                System.out.println("Робот не смог пробежать " + length + " метров.");
                return false;
            }
        }

        @Override
        public boolean jump(float height) {
            if (MaxJump >= height) {
                System.out.println("Робот прыгнул на  " + height + " метров.");
                return true;
            } else
            {
                System.out.println("Робот не смог прыгнуть на " + height + " метров.");
                return false;
            }
        }

    }


    public static void main(String[] args) {

        Moving h1 = new Human();
        Moving c1 = new Cat();
        Moving r1 = new Robot();

        Moving[] H = {
                h1,
                c1,
                r1
        };

        Track[] T = {
                new Track(),
                new Track(),
                new Track()
        };
        T[0].TrackLength = 200;
        T[1].TrackLength = 900;
        T[2].TrackLength = 1500;

        Wall[] W = {
                new Wall(),
                new Wall(),
                new Wall(),
                new Wall()
        };

        W[0].WallHeight = 0.5F;
        W[1].WallHeight = 1.9F;
        W[2].WallHeight = 3.6F;
        W[3].WallHeight = 8F;

        boolean result = true;

        for (Moving Hero: H) {
            for (Track track : T) {
                result = Hero.run(track.TrackLength);
                if (!result) break;
            }
            if (result) {
                for (Wall wall : W) {
                    result = Hero.jump(wall.WallHeight);
                    if (!result) break;
                }
            }
            System.out.println("------------------------------------------------------");
        }
    }
}
