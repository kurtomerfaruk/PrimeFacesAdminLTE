package com.kurtomerfaruk.admin.chart;

import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.theme.DarkBlueTheme;
import com.googlecode.wickedcharts.highcharts.theme.GrayTheme;
import com.googlecode.wickedcharts.highcharts.theme.GridTheme;
import com.googlecode.wickedcharts.highcharts.theme.SkiesTheme;
import com.googlecode.wickedcharts.highcharts.theme.Theme;
import com.googlecode.wickedcharts.showcase.options.AngularGaugeOptions;
import com.googlecode.wickedcharts.showcase.options.AreaInvertedAxisOptions;
import com.googlecode.wickedcharts.showcase.options.AreaMissingOptions;
import com.googlecode.wickedcharts.showcase.options.AreaRangeOptions;
import com.googlecode.wickedcharts.showcase.options.AreaSplineOptions;
import com.googlecode.wickedcharts.showcase.options.AreaWithNegativeValuesOptions;
import com.googlecode.wickedcharts.showcase.options.BarWithNegativeStackOptions;
import com.googlecode.wickedcharts.showcase.options.BasicAreaOptions;
import com.googlecode.wickedcharts.showcase.options.BasicBarOptions;
import com.googlecode.wickedcharts.showcase.options.BasicColumnOptions;
import com.googlecode.wickedcharts.showcase.options.BasicLineOptions;
import com.googlecode.wickedcharts.showcase.options.BubbleChartOptions;
import com.googlecode.wickedcharts.showcase.options.ClickToAddAPointOptions;
import com.googlecode.wickedcharts.showcase.options.ColumnRangeOptions;
import com.googlecode.wickedcharts.showcase.options.ColumnWithDrilldownOptions;
import com.googlecode.wickedcharts.showcase.options.ColumnWithNegativeValuesOptions;
import com.googlecode.wickedcharts.showcase.options.ColumnWithRotatedLabelsOptions;
import com.googlecode.wickedcharts.showcase.options.ComboOptions;
import com.googlecode.wickedcharts.showcase.options.DonutOptions;
import com.googlecode.wickedcharts.showcase.options.DualAxesOptions;
import com.googlecode.wickedcharts.showcase.options.InteractionOptions;
import com.googlecode.wickedcharts.showcase.options.LineWithDataLabelsOptions;
import com.googlecode.wickedcharts.showcase.options.LogarithmicAxisOptions;
import com.googlecode.wickedcharts.showcase.options.MultipleAxesOptions;
import com.googlecode.wickedcharts.showcase.options.PercentageAreaOptions;
import com.googlecode.wickedcharts.showcase.options.PieWithGradientOptions;
import com.googlecode.wickedcharts.showcase.options.PieWithLegendOptions;
import com.googlecode.wickedcharts.showcase.options.PolarOptions;
import com.googlecode.wickedcharts.showcase.options.ScatterPlotOptions;
import com.googlecode.wickedcharts.showcase.options.ScatterWithRegressionLineOptions;
import com.googlecode.wickedcharts.showcase.options.SpiderwebOptions;
import com.googlecode.wickedcharts.showcase.options.SplineWithInvertedAxisOptions;
import com.googlecode.wickedcharts.showcase.options.SplineWithPlotBandsOptions;
import com.googlecode.wickedcharts.showcase.options.SplineWithSymbolsOptions;
import com.googlecode.wickedcharts.showcase.options.StackedAndGroupedColumnOptions;
import com.googlecode.wickedcharts.showcase.options.StackedAreaOptions;
import com.googlecode.wickedcharts.showcase.options.StackedBarOptions;
import com.googlecode.wickedcharts.showcase.options.StackedColumnOptions;
import com.googlecode.wickedcharts.showcase.options.StackedPercentageOptions;
import com.googlecode.wickedcharts.showcase.options.TimeDataWithIrregularIntervalsOptions;
import com.googlecode.wickedcharts.showcase.options.WindroseOptions;
import com.googlecode.wickedcharts.showcase.options.ZoomableTimeSeriesOptions;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
@ViewScoped
public class Showcase implements java.io.Serializable {

    private static final long serialVersionUID = 1324599574911034020L;
    private Options options = null;
    private Theme theme = null;

    /**
     *
     */
    public Showcase() {
        this.selectBasicPieOptions();
        this.selectDefaultTheme();
        //this.selectGridTheme();
    }

    /**
     *
     * @return
     */
    public String getOptionsValue() {
        return "#{myBean.options}";
    }

    /**
     *
     * @return
     */
    public String getThemeValue() {
        return "#{myBean.theme}";
    }

    /**
     *
     * @return
     */
    public String getThemeUrlRefValue() {
        return "#{myBean.themeUrlRef}";
    }

    /* Theme */
    /**
     *
     * @return
     */
    public Theme getTheme() {
        return this.theme;
    }

    /**
     *
     * @param theme
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     *
     */
    public void selectDefaultTheme() {
        this.setTheme(null);
    }

    /**
     *
     */
    public void selectGridTheme() {
        this.setTheme(new GridTheme());
    }

    /**
     *
     */
    public void selectSkiesTheme() {
        this.setTheme(new SkiesTheme());
    }

    /**
     *
     */
    public void selectGrayTheme() {
        this.setTheme(new GrayTheme());
    }

    /**
     *
     */
    public void selectDarkBlueTheme() {
        this.setTheme(new DarkBlueTheme());
    }

    /* Options */
    /**
     *
     * @return
     */
    public Options getOptions() {
        return this.options;
    }

    /**
     *
     * @param options
     */
    public void setOptions(Options options) {
        this.options = options;
    }

    /**
     *
     */
    public void selectBasicLineOptions() {
        this.setOptions(new BasicLineOptions());
    }

    /**
     *
     */
    public void selectSplineWithSymbolsOptions() {
        this.setOptions(new SplineWithSymbolsOptions());
    }

    /**
     *
     */
    public void selectIrregularIntervalsOptions() {
        this.setOptions(new TimeDataWithIrregularIntervalsOptions());
    }

    /* Lines */
    /**
     *
     */
    public void selectLineWithDataLabelsOptions() {
        this.setOptions(new LineWithDataLabelsOptions());
    }

    /**
     *
     */
    public void selectZoomableTimeSeriesOptions() {
        this.setOptions(new ZoomableTimeSeriesOptions(false));
    }

    /**
     *
     */
    public void selectSplineWithInvertedAxisOptions() {
        this.setOptions(new SplineWithInvertedAxisOptions());
    }

    /**
     *
     */
    public void selectSplineWithPlotBandsOptions() {
        this.setOptions(new SplineWithPlotBandsOptions());
    }

    /**
     *
     */
    public void selectTimeDataWithIrregularIntervalsOptions() {
        this.setOptions(new TimeDataWithIrregularIntervalsOptions());
    }

    /**
     *
     */
    public void selectLogarithmicAxisOptions() {
        this.setOptions(new LogarithmicAxisOptions());
    }

    /**
     *
     */
    public void selectScatterOptions() {
        this.setOptions(new ScatterPlotOptions());
    }

    /* Area */
    /**
     *
     */
    public void selectBasicAreaOptions() {
        this.setOptions(new BasicAreaOptions());
    }

    /**
     *
     */
    public void selectAreaWithNegativeValuesOptions() {
        this.setOptions(new AreaWithNegativeValuesOptions());
    }

    /**
     *
     */
    public void selectStackedAreaOptions() {
        this.setOptions(new StackedAreaOptions());
    }

    /**
     *
     */
    public void selectPercentageAreaOptions() {
        this.setOptions(new PercentageAreaOptions());
    }

    /**
     *
     */
    public void selectAreaWithMissingOptions() {
        this.setOptions(new AreaMissingOptions());
    }

    /**
     *
     */
    public void selectAreaWithInvertedAxisOptions() {
        this.setOptions(new AreaInvertedAxisOptions());
    }

    /**
     *
     */
    public void selectAreaSplineOptions() {
        this.setOptions(new AreaSplineOptions());
    }

    /* Column and Bar */
    /**
     *
     */
    public void selectBasicBarOptions() {
        this.setOptions(new BasicBarOptions());
    }

    /**
     *
     */
    public void selectStackedBarOptions() {
        this.setOptions(new StackedBarOptions());
    }

    /**
     *
     */
    public void selectBarWithNegativeStackOptions() {
        this.setOptions(new BarWithNegativeStackOptions());
    }

    /**
     *
     */
    public void selectBasicColumnOptions() {
        this.setOptions(new BasicColumnOptions());
    }

    /**
     *
     */
    public void selectColumnWithNegativeValuesOptions() {
        this.setOptions(new ColumnWithNegativeValuesOptions());
    }

    /**
     *
     */
    public void selectStackedColumnOptions() {
        this.setOptions(new StackedColumnOptions());
    }

    /**
     *
     */
    public void selectStackedAndGroupedColoumOptions() {
        this.setOptions(new StackedAndGroupedColumnOptions());
    }

    /**
     *
     */
    public void selectStackedPercentagetOptions() {
        this.setOptions(new StackedPercentageOptions());
    }

    /**
     *
     */
    public void selectColumnWithRotatedLabelsOptions() {
        this.setOptions(new ColumnWithRotatedLabelsOptions());
    }

    /**
     *
     */
    public void selectColumnWithDrilldownOptions() {
        this.setOptions(new ColumnWithDrilldownOptions());
    }

    /* Pie */
    /**
     *
     */
    public void selectBasicPieOptions() {
        //this.setOptions(new BasicPieOptions());
        this.setOptions(new Pie());
    }

    /**
     *
     */
    public void selectPieWithGradientOptions() {
        this.setOptions(new PieWithGradientOptions());
    }

    /**
     *
     */
    public void selectDonutOptions() {
        this.setOptions(new DonutOptions());
    }

    /**
     *
     */
    public void selectPieWithLegendOptions() {
        this.setOptions(new PieWithLegendOptions());
    }

    /* Dynamic */
    /**
     *
     */
    public void selectClickToAddPointOptions() {
        this.setOptions(new ClickToAddAPointOptions());
    }

    /* Combinations */
    /**
     *
     */
    public void selectComboOptions() {
        this.setOptions(new ComboOptions());
    }

    /**
     *
     */
    public void selectDualAxesLineColumnOptions() {
        this.setOptions(new DualAxesOptions());
    }

    /**
     *
     */
    public void selectMultipleAxesOptions() {
        this.setOptions(new MultipleAxesOptions());
    }

    /**
     *
     */
    public void selectScatterWithRegressionLineOptions() {
        this.setOptions(new ScatterWithRegressionLineOptions());
    }

    /* More chart types */
    /**
     *
     */
    public void selectAngularGaugeOptions() {
        this.setOptions(new AngularGaugeOptions());
    }

    /**
     *
     */
    public void selectAreaRangeOptions() {
        this.setOptions(new AreaRangeOptions());
    }

    /**
     *
     */
    public void selectColumnRangeOptions() {
        this.setOptions(new ColumnRangeOptions());
    }

    /**
     *
     */
    public void selectPolarOptions() {
        this.setOptions(new PolarOptions());
    }

    /**
     *
     */
    public void selectSpiderwebOptions() {
        this.setOptions(new SpiderwebOptions());
    }

    /**
     *
     */
    public void selectWindroseOptions() {
        this.setOptions(new WindroseOptions());
    }

    /**
     *
     */
    public void selectBubbleChart() {
        this.setOptions(new BubbleChartOptions());
    }

    /**
     *
     */
    public void selectClientServerInteractionOptions() {
        this.setOptions(new InteractionOptions());
    }
}
