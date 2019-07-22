# Gradient Text View

## How to use

### 1. Add jitpack repository
Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the dependency

```
dependencies {
    implementation 'com.github.moh-affan:GradientTextView:Tag'
}
```

### 3. Use it in your own project
```
<dev.affan.GradientTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center_horizontal"
    android:gravity="center_horizontal"
    android:text="Hello World!"
    android:textSize="36sp"
    app:color_end="@color/mild_end"
    app:color_start="@color/mild_start"
    app:with_shadow="true" />

<dev.affan.GradientTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center_horizontal"
    android:text="Hello World!"
    android:textSize="42sp"
    android:textStyle="bold"
    app:color_end="@color/lunada_end"
    app:color_middle="@color/lunada_middle"
    app:color_start="@color/lunada_start"
    app:shadow_color="@color/moonlite_middle"
    app:shadow_dx="2.5"
    app:shadow_dy="2.5"
    app:shadow_radius="2.5"
    app:with_shadow="true" />
```

## Attributes
### 1. `color_start` (color) : Start color of the gradient
### 2. `color_middle` (color): Middle color of the gradient, may not used
### 3. `color_end` (color): End color of the gradient, may not used
### 4. `with_shadow` (boolean): whether to use shadow or not 
### 5. `shadow_color` (color): the color of the shadow 
### 6. `shadow_radius` (float): the radius of the shadow 
### 7. `shadow_dx` (float): the distance of x axis of the shadow 
### 8. `shadow_dy` (float): the distance of y axis of the shadow 
