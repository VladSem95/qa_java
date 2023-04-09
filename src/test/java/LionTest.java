public class LionTest {
    @Test
    public void lionHasMane() {
        // Arrage
        Lion lion = new Lion("Самец");
        boolean expectedHasMane = true;
        //Act
        boolean actualHasMane = lion.Lion();
        //Assert
        assertEquals(expectedHasMane, actualHasMane);
    }
}
