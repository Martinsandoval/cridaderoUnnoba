/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.PesajeDAO;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import modelo.Pesaje;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Sandoval
 */
@ManagedBean
public class ChartView {

    private LineChartModel lineModel1;
    @ManagedProperty(value="#{backingPesaje}") //Tira error de inyeccion
    private BackingPesaje backingPesaje;
   
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
    
    
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }
     public BackingPesaje getBackingPesaje() {
        return backingPesaje;
    }

    public void setBackingPesaje(BackingPesaje backingPesaje) {
        this.backingPesaje = backingPesaje;
    }
    
    public Collection<Pesaje>getPesajes(){
        return backingPesaje.getIdCerdo().getPesajeCollection(); //Tira una excepcion de inyeccion aca
    }
    

    
     private void createLineModels() {
        lineModel1 = initCategoryModel();
        lineModel1.setTitle("Grafico del pesaje");
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Fecha"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Peso");
        yAxis.setMin(backingPesaje.minPeso());
        yAxis.setMax(backingPesaje.maxPeso());
     }
     
    
     
     private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
 
        ChartSeries grafico = new ChartSeries();
        grafico.setLabel("Pesaje Cerdo");
          
         for(Pesaje p: backingPesaje.getCerdo().getPesajeCollection()){
             SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
             
         grafico.set(format.format(p.getFecha()), p.getValor());
        
        }
       
         model.addSeries(grafico);
         return model;
     }
     
   
}
