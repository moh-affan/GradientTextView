package dev.affan

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.TextView
import dev.affan.R


class GradientTextView : TextView {
    private lateinit var gradient: LinearGradient
    private var startColor: Int = Color.parseColor("#11998e")
    private var endColor: Int = Color.parseColor("#38ef7d")
    private var middleColor: Int = -1
    private var withShadow = false
    private var _shadowRadius = 1.5f
    private var _shadowDx = -1.5f
    private var _shadowDy = 1.5f
    private var _shadowColor = Color.LTGRAY

    constructor(context: Context) : super(context) {
        setGradient()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttrs(context.obtainStyledAttributes(attrs, R.styleable.GradientTextView))
        setGradient()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(context.obtainStyledAttributes(attrs, R.styleable.GradientTextView))
        setGradient()
    }

    private fun initAttrs(a: TypedArray) {
        startColor = a.getColor(R.styleable.GradientTextView_color_start, startColor)
        endColor = a.getColor(R.styleable.GradientTextView_color_end, endColor)
        middleColor = a.getColor(R.styleable.GradientTextView_color_middle, -1)
        withShadow = a.getBoolean(R.styleable.GradientTextView_with_shadow, false)
        _shadowRadius = a.getFloat(R.styleable.GradientTextView_shadow_radius, _shadowRadius)
        _shadowDx = a.getFloat(R.styleable.GradientTextView_shadow_dx, _shadowDx)
        _shadowDy = a.getFloat(R.styleable.GradientTextView_shadow_dy, _shadowDy)
        _shadowColor = a.getColor(R.styleable.GradientTextView_shadow_color, _shadowColor)
    }

    private fun setGradient() {
        val colors = mutableListOf<Int>()
        colors.add(0, startColor)
        if (middleColor != -1) {
            colors.add(1, middleColor)
            colors.add(2, endColor)
        } else
            colors.add(1, endColor)
        val width = paint.measureText(text.toString())
        if (withShadow)
            setShadowLayer(_shadowRadius, _shadowDx, _shadowDy, _shadowColor)
        setTextColor(Color.WHITE)
        gradient = LinearGradient(
            0f, 0f, width, textSize,
            colors.toIntArray(), null, Shader.TileMode.CLAMP
        )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            paint.shader = gradient
        }
    }
}