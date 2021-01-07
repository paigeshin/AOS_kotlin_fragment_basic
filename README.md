# Fragment

### Knowledge

- In fragment, you can't access views from `onCreate()`
- In fragment, you can access views on `onViewCreated()`
- You can replace `onCreateView()` by adding `R.layout.fragment` in the argument of super class `Fragment`
- Fragment

```kotlin
//Fragment doesn't have `stack`
class FirstFragment : Fragment(R.layout.fragment_first) {

    //You can replace this code below with `Constructor Argument`, `Fragment(R.layout.fragment_first)`
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }

    //You can't access to views with `onCreate()` in fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //You can access view from here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}

```

### Get fragment from activity

```kotlin
supportFragmentManager.beginTransaction().apply {
    replace(R.id.flFragment, firstFragment)
    commit()
}
```

### Backstack

- Fragment doesn't have any stacks
- If you want to add a stack, you can call `addToBackStack()`

```kotlin
btnFragment1.setOnClickListener {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.flFragment, firstFragment)
        addToBackStack(null) //because fragment doesn't have its own stack...
        commit()
    }
}
```

### XML, access directly to fragment

```xml
<fragment
        android:name="com.paigesoftware.androidfragmentfundamental.FirstFragment"
        android:id="@+id/fragment"
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

### XML, using framelayout, host fragments

```xml
<!-- Normally you use framelayout -->
    <FrameLayout
        android:id="@+id/flFragment"
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

# Entire Code

- Activity

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                addToBackStack(null) //because fragment doesn't have its own stack...
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                commit()
            }
        }

    }
}
```

- FristFragment

```kotlin
//Fragment doesn't have `stack`
class FirstFragment : Fragment(R.layout.fragment_first) {

    //You can replace this code below with `Constructor Argument`, `Fragment(R.layout.fragment_first)`
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }

    //You can't access to views with `onCreate()` in fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //You can access view from here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
```

- SecondFragment

```kotlin
class SecondFragment : Fragment(R.layout.fragment_second) {

}
```

- xml, hosting layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:weightSum="10"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_weight="2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:weightSum="10">
        <Button
            android:layout_weight="5"
            android:id="@+id/btnFragment1"
            android:text="Fragment1"
            android:layout_margin="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
        <Button
            android:layout_weight="5"
            android:id="@+id/btnFragment2"
            android:text="Fragment1"
            android:layout_margin="10dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </LinearLayout>

    <!-- access fragment directory -->
<!--    <fragment-->
<!--        android:name="com.paigesoftware.androidfragmentfundamental.FirstFragment"-->
<!--        android:id="@+id/fragment"-->
<!--        android:layout_margin="10dp"-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="match_parent"/>-->

    <!-- Normally you use framelayout -->
    <FrameLayout
        android:id="@+id/flFragment"
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</LinearLayout>
```