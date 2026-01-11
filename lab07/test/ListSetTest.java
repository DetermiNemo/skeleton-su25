import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.Truth.assertThat;

public class ListSetTest {

    @Test
    public void testBasics() {
        ListSet aSet = new ListSet();
        assertWithMessage("Size is not zero upon instantiation").that(aSet.size()).isEqualTo(0);
        for (int i = -50; i < 50; i += 2) {
            aSet.add(i);
            assertWithMessage("aSet should contain " + i).that(aSet.contains(i));
        }

        assertWithMessage("Size is not 50 after 50 calls to add").that(aSet.size()).isEqualTo(50);
        for (int i = -50; i < 50; i += 2) {
            aSet.remove(i);
            assertWithMessage("aSet should not contain " + i).that(!aSet.contains(i));
        }

        assertWithMessage("aSet is not empty after removing all elements").that(aSet.isEmpty());
        assertWithMessage("Size is not zero after removing all elements").that(aSet.size()).isEqualTo(0);
    }

    @Test
    public void testDuplicateAdd() {
        // 测试重复添加 - Set的核心特性
        ListSet set = new ListSet();
        set.add(5);
        assertThat(set.size()).isEqualTo(1);
        set.add(5);  // 重复添加
        assertThat(set.size()).isEqualTo(1);  // size不应增加
        set.add(5);  // 再次重复
        assertThat(set.size()).isEqualTo(1);
        assertThat(set.contains(5)).isTrue();
    }

    @Test
    public void testRemoveNonExistent() {
        // 测试删除不存在的元素
        ListSet set = new ListSet();
        set.add(1);
        set.add(2);
        set.remove(999);  // 删除不存在的元素
        assertThat(set.size()).isEqualTo(2);  // size不变
        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(2)).isTrue();
    }

    @Test
    public void testRemoveFromEmpty() {
        // 测试从空集合删除
        ListSet set = new ListSet();
        set.remove(5);  // 不应抛异常
        assertThat(set.isEmpty()).isTrue();
        assertThat(set.size()).isEqualTo(0);
    }

    @Test
    public void testMultipleRemoveSameElement() {
        // 测试多次删除同一元素
        ListSet set = new ListSet();
        set.add(10);
        set.remove(10);
        assertThat(set.contains(10)).isFalse();
        set.remove(10);  // 再次删除已删除的元素
        assertThat(set.size()).isEqualTo(0);
    }

    @Test
    public void testBoundaryValues() {
        // 测试边界值
        ListSet set = new ListSet();
        set.add(Integer.MAX_VALUE);
        set.add(Integer.MIN_VALUE);
        set.add(0);
        
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains(Integer.MAX_VALUE)).isTrue();
        assertThat(set.contains(Integer.MIN_VALUE)).isTrue();
        assertThat(set.contains(0)).isTrue();
        
        set.remove(Integer.MAX_VALUE);
        assertThat(set.contains(Integer.MAX_VALUE)).isFalse();
        assertThat(set.size()).isEqualTo(2);
    }

    @Test
    public void testSingleElement() {
        // 测试单元素集合
        ListSet set = new ListSet();
        set.add(42);
        
        assertThat(set.isEmpty()).isFalse();
        assertThat(set.size()).isEqualTo(1);
        assertThat(set.contains(42)).isTrue();
        
        set.remove(42);
        assertThat(set.isEmpty()).isTrue();
        assertThat(set.size()).isEqualTo(0);
    }

    @Test
    public void testToIntArrayEmpty() {
        // 测试空集合的toIntArray
        ListSet set = new ListSet();
        int[] arr = set.toIntArray();
        
        assertThat(arr).isNotNull();
        assertThat(arr.length).isEqualTo(0);
    }

    @Test
    public void testToIntArrayContent() {
        // 测试toIntArray的内容正确性
        ListSet set = new ListSet();
        set.add(3);
        set.add(1);
        set.add(4);
        set.add(1);  // 重复，不应加入
        set.add(5);
        
        int[] arr = set.toIntArray();
        assertThat(arr.length).isEqualTo(4);  // 只有4个唯一元素
        
        // 验证所有元素都在数组中
        ListSet checkSet = new ListSet();
        for (int val : arr) {
            checkSet.add(val);
        }
        assertThat(checkSet.contains(3)).isTrue();
        assertThat(checkSet.contains(1)).isTrue();
        assertThat(checkSet.contains(4)).isTrue();
        assertThat(checkSet.contains(5)).isTrue();
    }

    @Test
    public void testAddRemoveAdd() {
        // 测试添加-删除-再添加
        ListSet set = new ListSet();
        set.add(7);
        assertThat(set.contains(7)).isTrue();
        
        set.remove(7);
        assertThat(set.contains(7)).isFalse();
        assertThat(set.size()).isEqualTo(0);
        
        set.add(7);  // 再次添加
        assertThat(set.contains(7)).isTrue();
        assertThat(set.size()).isEqualTo(1);
    }

    @Test
    public void testContainsNonExistent() {
        // 测试查询不存在的元素
        ListSet set = new ListSet();
        set.add(1);
        set.add(2);
        
        assertThat(set.contains(999)).isFalse();
        assertThat(set.contains(-999)).isFalse();
        assertThat(set.contains(0)).isFalse();
    }

    @Test
    public void testNegativeNumbers() {
        // 测试负数
        ListSet set = new ListSet();
        set.add(-1);
        set.add(-100);
        set.add(-5);
        
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains(-1)).isTrue();
        assertThat(set.contains(-100)).isTrue();
        assertThat(set.contains(-5)).isTrue();
    }

    @Test
    public void testLargeNumberOfElements() {
        // 测试大量元素
        ListSet set = new ListSet();
        int count = 1000;
        
        for (int i = 0; i < count; i++) {
            set.add(i);
        }
        
        assertThat(set.size()).isEqualTo(count);
        
        for (int i = 0; i < count; i++) {
            assertThat(set.contains(i)).isTrue();
        }
        
        // 删除一半
        for (int i = 0; i < count; i += 2) {
            set.remove(i);
        }
        
        assertThat(set.size()).isEqualTo(count / 2);
    }

    @Test
    public void testZeroValue() {
        // 测试零值
        ListSet set = new ListSet();
        set.add(0);
        
        assertThat(set.contains(0)).isTrue();
        assertThat(set.size()).isEqualTo(1);
        
        set.add(0);  // 重复添加
        assertThat(set.size()).isEqualTo(1);
        
        set.remove(0);
        assertThat(set.contains(0)).isFalse();
    }

    @Test
    public void testAlternatingAddRemove() {
        // 测试交替添加删除
        ListSet set = new ListSet();
        
        for (int i = 0; i < 10; i++) {
            set.add(i);
            if (i % 2 == 0) {
                set.remove(i);
            }
        }
        
        // 只有奇数应该保留
        assertThat(set.size()).isEqualTo(5);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                assertThat(set.contains(i)).isTrue();
            } else {
                assertThat(set.contains(i)).isFalse();
            }
        }
    }
}