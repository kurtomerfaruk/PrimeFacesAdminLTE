package com.kurtomerfaruk.admin.chart;


import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.Cursor;
import com.googlecode.wickedcharts.highcharts.options.DataLabels;
import com.googlecode.wickedcharts.highcharts.options.PlotOptions;
import com.googlecode.wickedcharts.highcharts.options.PlotOptionsChoice;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.color.NullColor;
import com.googlecode.wickedcharts.highcharts.options.series.Point;
import com.googlecode.wickedcharts.highcharts.options.series.PointSeries;
import com.googlecode.wickedcharts.highcharts.options.series.Series;
import com.googlecode.wickedcharts.showcase.options.base.ShowcaseOptions;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Omer Faruk KURT e-mail:kurtomerfaruk@gmail.com
 */
@ManagedBean
public class Pie extends ShowcaseOptions {

    private static final long serialVersionUID = -1997310262149937780L;

    /**
     * Default Constructor
     */
    public Pie() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ADMIN_PU");
        EntityManager em;
        em = emf.createEntityManager();
        List result = em.createNativeQuery("SELECT sakila.language.name,count(sakila.film.film_id) FROM sakila.film,sakila.language where sakila.film.language_id=sakila.language.language_id group by sakila.language.name").getResultList();

        List<Series> chart = new ArrayList<Series>();
        List<Long> deger = new ArrayList<Long>();
        List<String> etiket = new ArrayList<String>();
        PointSeries test = new PointSeries();
        List<Point> point = new ArrayList<Point>();

        for (Object result1 : result) {
            deger.add((Long) ((Object[]) result1)[1]);
            etiket.add((String) ((Object[]) result1)[0]);
        }

        setChartOptions(new ChartOptions()
                .setPlotBackgroundColor(new NullColor())
                .setPlotBorderWidth(null)
                .setPlotShadow(Boolean.FALSE));

        setTitle(new Title("Film Language"));

        setTooltip(new Tooltip()
                .setPointFormat("{series.name}: <b>{point.percentage}%</b>")
                .setPercentageDecimals(1));

        setPlotOptions(new PlotOptionsChoice()
                .setPie(new PlotOptions()
                        .setAllowPointSelect(Boolean.TRUE)
                        .setCursor(Cursor.POINTER)
                        .setDataLabels(new DataLabels()
                                .setEnabled(Boolean.TRUE))
                        .setShowInLegend(Boolean.TRUE)));

        for (int i = 0; i < deger.size(); i++) {
            point.add(new Point(etiket.get(i), deger.get(i)));
        }
        test.setType(SeriesType.PIE);
        test.setData(point);
        test.setName("Language");
        addSeries(test);
    }

    @Override
    public String getLabel() {
        return "Pie with legend";
    }
}
