package com.kvg.nTools;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.TableCursor;
import javax.baja.file.BIFile;
import javax.baja.gx.BBrush;
import javax.baja.gx.BColor;
import javax.baja.naming.BOrd;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.*;
import java.io.*;
import javax.baja.file.*;
import javax.baja.naming.*;
import javax.baja.query.BQueryResult;
import javax.baja.sys.*;
import javax.baja.nre.annotations.*;
import javax.baja.sys.BAbstractService;
import javax.baja.query.*;
import javax.baja.collection.*;
import javax.baja.status.*;
import javax.xml.stream.events.StartDocument;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import javax.baja.file.*;
import javax.baja.sys.*;
import javax.baja.naming.*;
import javax.baja.history.ext.*;
import javax.baja.history.*;
import javax.baja.tag.*;
import javax.baja.util.BFormat;
import javax.baja.naming.OrdQuery;
import javax.baja.util.CloseableIterator;
import javax.baja.neql.*;

@NiagaraType

@NiagaraProperty(
        name = "Status",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "not running"
)
@NiagaraProperty(
        name = "historiesLastAdded",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "never"
)
@NiagaraProperty(
        name = "NumberOfHistoriesGenerated",
        type = "int",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "0"
)


@NiagaraProperty(
        name = "HistoryNameFormat",
        type = "BFormat",
        flags = Flags.SUMMARY,
        defaultValue = "BFormat.make(\"%parent.parent.parent.name%_%parent.name%\")"
)
@NiagaraProperty(
        name = "COVHistoryNameFormat",
        type = "BFormat",
        flags = Flags.SUMMARY,
        defaultValue = "BFormat.make(\"%parent.parent.parent.name%_%parent.name%_COV\")"
)

@NiagaraAction(
        name = "addHistoryExtensions"
)


public class BAddHistories extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.kvg.nTools.BAddHistories(3696012535)1.0$ @*/
/* Generated Mon Mar 16 10:29:24 BOT 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "Status"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Status} property.
   * @see #getStatus
   * @see #setStatus
   */
  public static final Property Status = newProperty(Flags.SUMMARY | Flags.READONLY, "not running", null);
  
  /**
   * Get the {@code Status} property.
   * @see #Status
   */
  public String getStatus() { return getString(Status); }
  
  /**
   * Set the {@code Status} property.
   * @see #Status
   */
  public void setStatus(String v) { setString(Status, v, null); }

////////////////////////////////////////////////////////////////
// Property "historiesLastAdded"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code historiesLastAdded} property.
   * @see #getHistoriesLastAdded
   * @see #setHistoriesLastAdded
   */
  public static final Property historiesLastAdded = newProperty(Flags.SUMMARY | Flags.READONLY, "never", null);
  
  /**
   * Get the {@code historiesLastAdded} property.
   * @see #historiesLastAdded
   */
  public String getHistoriesLastAdded() { return getString(historiesLastAdded); }
  
  /**
   * Set the {@code historiesLastAdded} property.
   * @see #historiesLastAdded
   */
  public void setHistoriesLastAdded(String v) { setString(historiesLastAdded, v, null); }

////////////////////////////////////////////////////////////////
// Property "NumberOfHistoriesGenerated"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code NumberOfHistoriesGenerated} property.
   * @see #getNumberOfHistoriesGenerated
   * @see #setNumberOfHistoriesGenerated
   */
  public static final Property NumberOfHistoriesGenerated = newProperty(Flags.SUMMARY | Flags.READONLY, 0, null);
  
  /**
   * Get the {@code NumberOfHistoriesGenerated} property.
   * @see #NumberOfHistoriesGenerated
   */
  public int getNumberOfHistoriesGenerated() { return getInt(NumberOfHistoriesGenerated); }
  
  /**
   * Set the {@code NumberOfHistoriesGenerated} property.
   * @see #NumberOfHistoriesGenerated
   */
  public void setNumberOfHistoriesGenerated(int v) { setInt(NumberOfHistoriesGenerated, v, null); }

////////////////////////////////////////////////////////////////
// Property "HistoryNameFormat"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code HistoryNameFormat} property.
   * @see #getHistoryNameFormat
   * @see #setHistoryNameFormat
   */
  public static final Property HistoryNameFormat = newProperty(Flags.SUMMARY, BFormat.make("%parent.parent.parent.name%_%parent.name%"), null);
  
  /**
   * Get the {@code HistoryNameFormat} property.
   * @see #HistoryNameFormat
   */
  public BFormat getHistoryNameFormat() { return (BFormat)get(HistoryNameFormat); }
  
  /**
   * Set the {@code HistoryNameFormat} property.
   * @see #HistoryNameFormat
   */
  public void setHistoryNameFormat(BFormat v) { set(HistoryNameFormat, v, null); }

////////////////////////////////////////////////////////////////
// Property "COVHistoryNameFormat"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code COVHistoryNameFormat} property.
   * @see #getCOVHistoryNameFormat
   * @see #setCOVHistoryNameFormat
   */
  public static final Property COVHistoryNameFormat = newProperty(Flags.SUMMARY, BFormat.make("%parent.parent.parent.name%_%parent.name%_COV"), null);
  
  /**
   * Get the {@code COVHistoryNameFormat} property.
   * @see #COVHistoryNameFormat
   */
  public BFormat getCOVHistoryNameFormat() { return (BFormat)get(COVHistoryNameFormat); }
  
  /**
   * Set the {@code COVHistoryNameFormat} property.
   * @see #COVHistoryNameFormat
   */
  public void setCOVHistoryNameFormat(BFormat v) { set(COVHistoryNameFormat, v, null); }

////////////////////////////////////////////////////////////////
// Action "addHistoryExtensions"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addHistoryExtensions} action.
   * @see #addHistoryExtensions()
   */
  public static final Action addHistoryExtensions = newAction(0, null);
  
  /**
   * Invoke the {@code addHistoryExtensions} action.
   * @see #addHistoryExtensions
   */
  public void addHistoryExtensions() { invoke(addHistoryExtensions, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAddHistories.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



    public void doAddHistoryExtensions() {

        setStatus("Running");

        BComponent comp;
        int numberOfHistories = 0;
        BOrd neqlQuery = BOrd.make("neql: (n:type='control:NumericPoint' and sbs:sensor) or (n:type='control:NumericPoint' and sbs:cmd) or (n:type='control:NumericPoint' and sbs:sp) or (n:type='control:NumericPoint' and hs:sensor) or (n:type='control:NumericPoint' and hs:cmd) or (n:type='control:NumericPoint' and hs:sp) or (n:type='control:NumericWritable' and sbs:sensor) or (n:type='control:NumericWritable' and sbs:cmd) or (n:type='control:NumericWritable' and sbs:sp) or (n:type='control:NumericWritable' and hs:sensor) or (n:type='control:NumericWritable' and hs:cmd) or (n:type='control:NumericWritable' and hs:sp)");
        BQueryResult result = (BQueryResult)neqlQuery.resolve(Sys.getStation()).get();
        CloseableIterator<Entity> results = result.getResults();
        setStatus("Generating Numeric Interval Histories");

        while(results.hasNext())


        {
// found entities with the neql query
            comp = (BComponent)results.next();
            if (comp.getSlot("history") == null)
            {
                BNumericIntervalHistoryExt hist = new BNumericIntervalHistoryExt();
                comp.add("history", hist);
                hist.setHistoryName(getHistoryNameFormat());
                hist.setEnabled(true);
                numberOfHistories++;
            }


        }
        setStatus("Numeric Histories Generated");


        BComponent comp1;
        BOrd neqlQuery1 = BOrd.make("neql: (n:type='control:Boolean.*' and sbs:sensor) or (n:type='control:BooleanPoint' and sbs:cmd) or (n:type='control:BooleanPoint' and sbs:sp) or (n:type='control:BooleanPoint' and hs:sensor) or (n:type='control:BooleanPoint' and hs:cmd) or (n:type='control:BooleanPoint' and hs:sp) or (n:type='control:BooleanWritable' and sbs:sensor) or (n:type='control:BooleanWritable' and sbs:cmd) or (n:type='control:BooleanWritable' and sbs:sp) or (n:type='control:BooleanWritable' and hs:sensor) or (n:type='control:BooleanWritable' and hs:cmd) or (n:type='control:BooleanWritable' and hs:sp)");
        BQueryResult result1 = (BQueryResult)neqlQuery1.resolve(Sys.getStation()).get();
        CloseableIterator<Entity> results1 = result1.getResults();
        setStatus("Generating Boolean COV Histories");

        while(results1.hasNext())

        {
// found entities with the neql query
            comp1 = (BComponent)results1.next();
            if (comp1.getSlot("history") == null)
            {
                BBooleanCovHistoryExt hist1 = new BBooleanCovHistoryExt();
                comp1.add("history", hist1);
                hist1.setHistoryName(getHistoryNameFormat());
                hist1.setEnabled(true);
                numberOfHistories++;
            }


        }

        setStatus("Boolean Histories Generated");

        BComponent comp2;
        BOrd neqlQuery2 = BOrd.make("neql: (n:type='control:EnumPoint' and sbs:sensor) or (n:type='control:EnumPoint' and sbs:cmd) or (n:type='control:EnumPoint' and sbs:sp) or (n:type='control:EnumPoint' and hs:sensor) or (n:type='control:EnumPoint' and hs:cmd) or (n:type='control:EnumPoint' and hs:sp) or (n:type='control:EnumWritable' and sbs:sensor) or (n:type='control:EnumWritable' and sbs:cmd) or (n:type='control:EnumWritable' and sbs:sp) or (n:type='control:EnumWritable' and hs:sensor) or (n:type='control:EnumWritable' and hs:cmd) or (n:type='control:EnumWritable' and hs:sp)");
        BQueryResult result2 = (BQueryResult)neqlQuery2.resolve(Sys.getStation()).get();
        CloseableIterator<Entity> results2 = result2.getResults();
        setStatus("Generating Enum COV Histories");

        while(results2.hasNext())
        {

// found entities with the neql query
            comp2 = (BComponent)results2.next();
            if (comp2.getSlot("history") == null)
            {
                BEnumCovHistoryExt hist2 = new BEnumCovHistoryExt();
                comp2.add("history", hist2);
                hist2.setHistoryName(getHistoryNameFormat());
                hist2.setEnabled(true);
                numberOfHistories++;
            }

        }
        setStatus("Enum Histories Generated");

        BComponent comp3;
        BOrd neqlQuery3 = BOrd.make("neql: ((n:type='control:NumericPoint' or n:type='control:NumericWritable') and sbs:cmd) or ((n:type='control:NumericPoint' or n:type='control:NumericWritable') and hs:cmd)");
        BQueryResult result3 = (BQueryResult)neqlQuery3.resolve(Sys.getStation()).get();
        CloseableIterator<Entity> results3 = result3.getResults();
        setStatus("Generating Numeric COV Histories");

        while(results3.hasNext())
        {

// found entities with the neql query
            comp3 = (BComponent)results3.next();
            if (comp3.getSlot("historyCOV") == null)
            {
                BNumericCovHistoryExt hist3 = new BNumericCovHistoryExt();
                comp3.add("historyCOV", hist3);
                hist3.setHistoryName(getCOVHistoryNameFormat());
                hist3.setEnabled(true);
                hist3.setChangeTolerance(1);
                numberOfHistories++;
            }


        }
        Date date = new Date();
        String currentDate = date.toString();
        setHistoriesLastAdded(currentDate);
        setNumberOfHistoriesGenerated(numberOfHistories);
        setStatus("Completed");

    }
    @Override
    public BIcon getIcon() {
        return BIcon.std("history.png");
    }

        }





