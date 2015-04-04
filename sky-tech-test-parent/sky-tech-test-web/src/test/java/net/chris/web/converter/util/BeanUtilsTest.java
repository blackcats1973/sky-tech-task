package net.chris.web.converter.util;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

/**
 * Unit test cases for {@link BeanUtils}.
 * 
 * @author Chris Hern
 * 
 */
public class BeanUtilsTest {

    @Test
    public void testCopyProperties() {
        // arrange
        final ObjectA objA = new ObjectA("one", true, 3);
        final ObjectB objB = new ObjectB();

        assertThat(objA.getFieldOne()).isEqualTo("one");
        assertThat(objA.isFieldTwo()).isTrue();
        assertThat(objA.getFieldThree()).isEqualTo(3);
        assertThat(objB.getFieldOne()).isNull();
        assertThat(objB.isFieldTwo()).isFalse();
        assertThat(objB.getFieldThree()).isEqualTo(0);

        // act
        BeanUtils.copyProperties(objA, objB);

        // assert
        assertThat(objB.getFieldOne()).isEqualTo("one");
        assertThat(objB.isFieldTwo()).isTrue();
        assertThat(objB.getFieldThree()).isEqualTo(3);
    }

    private class ObjectA {
        private String fieldOne;
        private boolean fieldTwo;
        private int fieldThree;

        @SuppressWarnings("unused")
        public ObjectA() {
        }

        public ObjectA(final String fieldOne, final boolean fieldTwo, final int fieldThree) {
            this.fieldOne = fieldOne;
            this.fieldTwo = fieldTwo;
            this.fieldThree = fieldThree;
        }

        /**
         * @return the fieldOne
         */
        public String getFieldOne() {
            return fieldOne;
        }

        /**
         * @return the fieldTwo
         */
        public boolean isFieldTwo() {
            return fieldTwo;
        }

        /**
         * @return the fieldThree
         */
        public int getFieldThree() {
            return fieldThree;
        }

    }

    private class ObjectB {
        private String fieldOne;
        private boolean fieldTwo;
        private int fieldThree;

        public ObjectB() {

        };

        /**
         * @return the fieldOne
         */
        public String getFieldOne() {
            return fieldOne;
        }

        /**
         * @return the fieldTwo
         */
        public boolean isFieldTwo() {
            return fieldTwo;
        }

        /**
         * @return the fieldThree
         */
        public int getFieldThree() {
            return fieldThree;
        }

        /**
         * @param fieldOne
         *            the fieldOne to set
         */
        @SuppressWarnings("unused")
        public void setFieldOne(String fieldOne) {
            this.fieldOne = fieldOne;
        }

        /**
         * @param fieldTwo
         *            the fieldTwo to set
         */
        @SuppressWarnings("unused")
        public void setFieldTwo(boolean fieldTwo) {
            this.fieldTwo = fieldTwo;
        }

        /**
         * @param fieldThree
         *            the fieldThree to set
         */
        @SuppressWarnings("unused")
        public void setFieldThree(int fieldThree) {
            this.fieldThree = fieldThree;
        }
    }
}
