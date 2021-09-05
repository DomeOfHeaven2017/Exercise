package com.wx.exercise.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wx.exercise.R
import kotlin.math.ceil
import kotlin.math.floor

/**
 * author: DomeOfHeaven
 * date : 2021/1/27
 * desc :
 */
class DashboardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        isAntiAlias = true
        strokeCap = Paint.Cap.ROUND
        style = Paint.Style.STROKE
    }
    var maxProgress: Float = 1f
    /**
     * 进度参数
     */
    var progress: Float = 0f
            set(value) {
                field = value.coerceAtMost(maxProgress)
                progressDegree = progress / maxProgress * sweepDegree
                drawDegree = 0f
                animator?.cancel()
                animator = ObjectAnimator.ofFloat(this@DashboardView, "drawDegree", progressDegree)
                animator?.duration = 2000
                animator?.start()
                invalidate()
            }

    private var radius: Float = 0f

    private var strokeWidth: Float = 0f
                set(value) {
                    paint.strokeWidth = value
                    field = value
                }

    var progressColor: Int = 0

    var textColor: Int = 0

    var backColor: Int = 0

    var textSize: Float = 0f

    private var progressDegree: Float = 0f

    var drawDegree: Float = 0f

    private var rotateDegree: Float = 120f

    private var startDegree: Float = 15f

    private var sweepDegree: Float = 270f

    private var animator: ObjectAnimator? = null


    init {
        initAttrs(attrs)
    }

    /**
     * 属性获取
     */
    fun initAttrs(attrs: AttributeSet?) {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.dashboardProgress)
        attributes.apply {
            strokeWidth = getDimension(R.styleable.dashboardProgress_strokenWidth, 0f)
            radius = getDimension(R.styleable.dashboardProgress_radius, 0f)
            backColor = getColor(R.styleable.dashboardProgress_backColor, Color.RED)
            progressColor = getColor(R.styleable.dashboardProgress_progressColor, Color.BLUE)
            textColor = getColor(R.styleable.dashboardProgress_textColor, Color.BLACK)

            maxProgress = getFloat(R.styleable.dashboardProgress_maxProgress, 270f)
            progress = getFloat(R.styleable.dashboardProgress_progress, 0f)
            recycle()
        }

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(getMeasureSize(widthMeasureSpec), getMeasureSize(heightMeasureSpec))
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        canvas?.apply {
            val centerX = width / 2
            val centerY = height / 2
            val useWidth = width - paddingLeft - paddingRight - strokeWidth * 2
            val useHeight = height - paddingTop - paddingBottom - strokeWidth * 2
            radius = floor((useWidth.coerceAtMost(useHeight) / 2).toDouble()).toFloat()
                .coerceAtMost(radius)
            val rect = RectF(
                centerX - radius, centerY - radius,
                centerX + radius, centerY + radius
            )
            save()
            rotate(rotateDegree, centerX.toFloat(), centerY.toFloat())
            drawBack(this, rect)
            drawProgress(this, centerX, centerY, rect)
            restore()
        }
    }

    /**
     * 绘制背景
     */
    private fun drawBack(canvas: Canvas, rect: RectF) {
        paint.shader = null
        paint.color = backColor
        canvas.drawArc(rect, startDegree, sweepDegree, false, paint)
    }

    /**
     * 绘制进度条
     */
    private fun drawProgress(canvas: Canvas, centerX: Int, centerY: Int, rect: RectF) {
        paint.color = progressColor
//        paint.shader = SweepGradient(centerX.toFloat(), centerY.toFloat(), Color.parseColor("#21ADF1"), Color.parseColor("#2287EE"))
        canvas.drawArc(rect, startDegree, drawDegree, false, paint)
    }

    /**
     * 设置尺寸大小
     */
    private fun getMeasureSize(spec: Int): Int {
        val mode = MeasureSpec.getMode(spec)
        val size = MeasureSpec.getSize(spec)
        return when (mode) {
            //match_parent或者固定的值
            MeasureSpec.EXACTLY -> size
            //wrap_content, 最大为size
            MeasureSpec.AT_MOST -> {
                val temp = (ceil((radius.toDouble() + strokeWidth) * 2) + paddingLeft + paddingRight).toInt()
                temp.coerceAtMost(size)
            }
            else -> size
        }
    }
}