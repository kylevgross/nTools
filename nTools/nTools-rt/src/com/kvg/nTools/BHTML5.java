package com.kvg.nTools;

import com.tridium.nre.security.io.BogPasswordObjectEncoder;

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


@NiagaraType

@NiagaraProperty(
        name = "gettingStarted",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "To view the getting started guide -> right click on HTML5Service -> Views -> Guide Help",
        facets = {
                @Facet(name = "BFacets.FIELD_WIDTH", value = "90")

        }
)
@NiagaraProperty(
        name = "htmlLastGenerated",
        type = "String",
        flags = Flags.SUMMARY | Flags.READONLY,
        defaultValue = "never"
)

@NiagaraProperty(
        name = "htmlFolder",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"file:^graphics/html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IDirectory\"")
        }
)
@NiagaraProperty(
        name = "navFile",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/nav.nav\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "equipHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/equip.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "indexHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/index.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "scriptJS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/script.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "styleCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/style.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)


@NiagaraProperty(
        name = "bajascriptJs",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/js/bajascript.js\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "floorplanHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/floorplans.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "customHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/customNav.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "externalHTML",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/html/external.html\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)


@NiagaraProperty(
        name = "navCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/nav.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "logoCSS",
        type = "baja:Ord",
        flags = Flags.HIDDEN,
        defaultValue = "BOrd.make(\"file:^graphics/css/logo.css\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "siteTitle",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Niagara"

)


@NiagaraProperty(
        name = "logoPath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"file:^graphics/images/logo.png\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }

)
@NiagaraProperty(
        name = "minLogoWidth",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "150"
)
@NiagaraProperty(
        name = "maxLogoWidth",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "250"
)
@NiagaraProperty(
        name = "logoTopPadding",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "-10"
)
@NiagaraProperty(
        name = "navColor",
        type = "gx:Brush",
        flags = Flags.SUMMARY,
        defaultValue = "BBrush.makeSolid(BColor.orange)"

)
@NiagaraProperty(
        name = "hasOat",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "oat",
        type = "BString",
        flags = Flags.SUMMARY,
        defaultValue = "0"

)
@NiagaraProperty(
        name = "hasOah",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "oah",
        type = "BString",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)

@NiagaraProperty(
        name = "homePagePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Graphics/Home\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)


@NiagaraProperty(
        name = "hasEntSec",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "hasEquipment",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "equipListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Equipment"

)

@NiagaraProperty(
        name = "hasFloorplans",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "floorplanListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Floorplans"

)
@NiagaraProperty(
        name = "hasCustomNavItem",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "customListName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "Custom"

)
@NiagaraProperty(
        name = "hasExternalLink",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "externalLinkName",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = "External Link"

)
@NiagaraProperty(
        name = "externalLinkPath",
        type = "String",
        flags = Flags.SUMMARY,
        defaultValue = ""

)
@NiagaraProperty(
        name = "showHistories",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "showSchedules",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "schedulePagePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Drivers/Schedules\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)
@NiagaraProperty(
        name = "showReports",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)
@NiagaraProperty(
        name = "showDocs",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "true"
)

@NiagaraProperty(
        name = "hasNotificationConsole",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)
@NiagaraProperty(
        name = "notificationCount",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)
@NiagaraProperty(
        name = "notificationConsolePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"null\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)
@NiagaraProperty(
        name = "hasAlarmConsole",
        type = "boolean",
        flags = Flags.SUMMARY,
        defaultValue = "false"
)

@NiagaraProperty(
        name = "alarmCount",
        type = "double",
        flags = Flags.SUMMARY,
        defaultValue = "0"
)
@NiagaraProperty(
        name = "alarmConsolePath",
        type = "baja:Ord",
        flags = Flags.SUMMARY,
        defaultValue = "BOrd.make(\"station:|slot:/Services/AlarmService/AllAlarms\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IComponent\"")
        }
)



@NiagaraAction(
        name = "generateHTML"
)

public class BHTML5 extends BComponent {


    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.sbs.nTools.BHTML5(2435819158)1.0$ @*/
    /* Generated Wed Nov 13 06:24:51 EST 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "gettingStarted"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code gettingStarted} property.
     *
     * @see #getGettingStarted
     * @see #setGettingStarted
     */
    public static final Property gettingStarted = newProperty(Flags.SUMMARY | Flags.READONLY, "To view the getting started guide -> right click on HTML5Service -> Views -> Guide Help", BFacets.make(BFacets.FIELD_WIDTH, 90));

    /**
     * Get the {@code gettingStarted} property.
     *
     * @see #gettingStarted
     */
    public String getGettingStarted() {
        return getString(gettingStarted);
    }

    /**
     * Set the {@code gettingStarted} property.
     *
     * @see #gettingStarted
     */
    public void setGettingStarted(String v) {
        setString(gettingStarted, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "htmlLastGenerated"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code htmlLastGenerated} property.
     *
     * @see #getHtmlLastGenerated
     * @see #setHtmlLastGenerated
     */
    public static final Property htmlLastGenerated = newProperty(Flags.SUMMARY | Flags.READONLY, "never", null);

    /**
     * Get the {@code htmlLastGenerated} property.
     *
     * @see #htmlLastGenerated
     */
    public String getHtmlLastGenerated() {
        return getString(htmlLastGenerated);
    }

    /**
     * Set the {@code htmlLastGenerated} property.
     *
     * @see #htmlLastGenerated
     */
    public void setHtmlLastGenerated(String v) {
        setString(htmlLastGenerated, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "htmlFolder"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code htmlFolder} property.
     *
     * @see #getHtmlFolder
     * @see #setHtmlFolder
     */
    public static final Property htmlFolder = newProperty(Flags.SUMMARY, BOrd.make("file:^graphics/html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IDirectory"));

    /**
     * Get the {@code htmlFolder} property.
     *
     * @see #htmlFolder
     */
    public BOrd getHtmlFolder() {
        return (BOrd) get(htmlFolder);
    }

    /**
     * Set the {@code htmlFolder} property.
     *
     * @see #htmlFolder
     */
    public void setHtmlFolder(BOrd v) {
        set(htmlFolder, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "navFile"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code navFile} property.
     *
     * @see #getNavFile
     * @see #setNavFile
     */
    public static final Property navFile = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/nav.nav"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code navFile} property.
     *
     * @see #navFile
     */
    public BOrd getNavFile() {
        return (BOrd) get(navFile);
    }

    /**
     * Set the {@code navFile} property.
     *
     * @see #navFile
     */
    public void setNavFile(BOrd v) {
        set(navFile, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "equipHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code equipHTML} property.
     *
     * @see #getEquipHTML
     * @see #setEquipHTML
     */
    public static final Property equipHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/equip.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code equipHTML} property.
     *
     * @see #equipHTML
     */
    public BOrd getEquipHTML() {
        return (BOrd) get(equipHTML);
    }

    /**
     * Set the {@code equipHTML} property.
     *
     * @see #equipHTML
     */
    public void setEquipHTML(BOrd v) {
        set(equipHTML, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "indexHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code indexHTML} property.
     *
     * @see #getIndexHTML
     * @see #setIndexHTML
     */
    public static final Property indexHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/index.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code indexHTML} property.
     *
     * @see #indexHTML
     */
    public BOrd getIndexHTML() {
        return (BOrd) get(indexHTML);
    }

    /**
     * Set the {@code indexHTML} property.
     *
     * @see #indexHTML
     */
    public void setIndexHTML(BOrd v) {
        set(indexHTML, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "scriptJS"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code scriptJS} property.
     *
     * @see #getScriptJS
     * @see #setScriptJS
     */
    public static final Property scriptJS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/script.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code scriptJS} property.
     *
     * @see #scriptJS
     */
    public BOrd getScriptJS() {
        return (BOrd) get(scriptJS);
    }

    /**
     * Set the {@code scriptJS} property.
     *
     * @see #scriptJS
     */
    public void setScriptJS(BOrd v) {
        set(scriptJS, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "styleCSS"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code styleCSS} property.
     *
     * @see #getStyleCSS
     * @see #setStyleCSS
     */
    public static final Property styleCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/style.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code styleCSS} property.
     *
     * @see #styleCSS
     */
    public BOrd getStyleCSS() {
        return (BOrd) get(styleCSS);
    }

    /**
     * Set the {@code styleCSS} property.
     *
     * @see #styleCSS
     */
    public void setStyleCSS(BOrd v) {
        set(styleCSS, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "bajascriptJs"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code bajascriptJs} property.
     *
     * @see #getBajascriptJs
     * @see #setBajascriptJs
     */
    public static final Property bajascriptJs = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/js/bajascript.js"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code bajascriptJs} property.
     *
     * @see #bajascriptJs
     */
    public BOrd getBajascriptJs() {
        return (BOrd) get(bajascriptJs);
    }

    /**
     * Set the {@code bajascriptJs} property.
     *
     * @see #bajascriptJs
     */
    public void setBajascriptJs(BOrd v) {
        set(bajascriptJs, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "floorplanHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code floorplanHTML} property.
     *
     * @see #getFloorplanHTML
     * @see #setFloorplanHTML
     */
    public static final Property floorplanHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/floorplans.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code floorplanHTML} property.
     *
     * @see #floorplanHTML
     */
    public BOrd getFloorplanHTML() {
        return (BOrd) get(floorplanHTML);
    }

    /**
     * Set the {@code floorplanHTML} property.
     *
     * @see #floorplanHTML
     */
    public void setFloorplanHTML(BOrd v) {
        set(floorplanHTML, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "customHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code customHTML} property.
     *
     * @see #getCustomHTML
     * @see #setCustomHTML
     */
    public static final Property customHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/customNav.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code customHTML} property.
     *
     * @see #customHTML
     */
    public BOrd getCustomHTML() {
        return (BOrd) get(customHTML);
    }

    /**
     * Set the {@code customHTML} property.
     *
     * @see #customHTML
     */
    public void setCustomHTML(BOrd v) {
        set(customHTML, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "externalHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code externalHTML} property.
     *
     * @see #getExternalHTML
     * @see #setExternalHTML
     */
    public static final Property externalHTML = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/html/external.html"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code externalHTML} property.
     *
     * @see #externalHTML
     */
    public BOrd getExternalHTML() {
        return (BOrd) get(externalHTML);
    }

    /**
     * Set the {@code externalHTML} property.
     *
     * @see #externalHTML
     */
    public void setExternalHTML(BOrd v) {
        set(externalHTML, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "navCSS"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code navCSS} property.
     *
     * @see #getNavCSS
     * @see #setNavCSS
     */
    public static final Property navCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/nav.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code navCSS} property.
     *
     * @see #navCSS
     */
    public BOrd getNavCSS() {
        return (BOrd) get(navCSS);
    }

    /**
     * Set the {@code navCSS} property.
     *
     * @see #navCSS
     */
    public void setNavCSS(BOrd v) {
        set(navCSS, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "logoCSS"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code logoCSS} property.
     *
     * @see #getLogoCSS
     * @see #setLogoCSS
     */
    public static final Property logoCSS = newProperty(Flags.HIDDEN, BOrd.make("file:^graphics/css/logo.css"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code logoCSS} property.
     *
     * @see #logoCSS
     */
    public BOrd getLogoCSS() {
        return (BOrd) get(logoCSS);
    }

    /**
     * Set the {@code logoCSS} property.
     *
     * @see #logoCSS
     */
    public void setLogoCSS(BOrd v) {
        set(logoCSS, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "siteTitle"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code siteTitle} property.
     *
     * @see #getSiteTitle
     * @see #setSiteTitle
     */
    public static final Property siteTitle = newProperty(Flags.SUMMARY, "Niagara", null);

    /**
     * Get the {@code siteTitle} property.
     *
     * @see #siteTitle
     */
    public String getSiteTitle() {
        return getString(siteTitle);
    }

    /**
     * Set the {@code siteTitle} property.
     *
     * @see #siteTitle
     */
    public void setSiteTitle(String v) {
        setString(siteTitle, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "logoPath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code logoPath} property.
     *
     * @see #getLogoPath
     * @see #setLogoPath
     */
    public static final Property logoPath = newProperty(Flags.SUMMARY, BOrd.make("file:^graphics/images/logo.png"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));

    /**
     * Get the {@code logoPath} property.
     *
     * @see #logoPath
     */
    public BOrd getLogoPath() {
        return (BOrd) get(logoPath);
    }

    /**
     * Set the {@code logoPath} property.
     *
     * @see #logoPath
     */
    public void setLogoPath(BOrd v) {
        set(logoPath, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "minLogoWidth"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code minLogoWidth} property.
     *
     * @see #getMinLogoWidth
     * @see #setMinLogoWidth
     */
    public static final Property minLogoWidth = newProperty(Flags.SUMMARY, 150, null);

    /**
     * Get the {@code minLogoWidth} property.
     *
     * @see #minLogoWidth
     */
    public double getMinLogoWidth() {
        return getDouble(minLogoWidth);
    }

    /**
     * Set the {@code minLogoWidth} property.
     *
     * @see #minLogoWidth
     */
    public void setMinLogoWidth(double v) {
        setDouble(minLogoWidth, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "maxLogoWidth"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code maxLogoWidth} property.
     *
     * @see #getMaxLogoWidth
     * @see #setMaxLogoWidth
     */
    public static final Property maxLogoWidth = newProperty(Flags.SUMMARY, 250, null);

    /**
     * Get the {@code maxLogoWidth} property.
     *
     * @see #maxLogoWidth
     */
    public double getMaxLogoWidth() {
        return getDouble(maxLogoWidth);
    }

    /**
     * Set the {@code maxLogoWidth} property.
     *
     * @see #maxLogoWidth
     */
    public void setMaxLogoWidth(double v) {
        setDouble(maxLogoWidth, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "logoTopPadding"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code logoTopPadding} property.
     *
     * @see #getLogoTopPadding
     * @see #setLogoTopPadding
     */
    public static final Property logoTopPadding = newProperty(Flags.SUMMARY, -10, null);

    /**
     * Get the {@code logoTopPadding} property.
     *
     * @see #logoTopPadding
     */
    public double getLogoTopPadding() {
        return getDouble(logoTopPadding);
    }

    /**
     * Set the {@code logoTopPadding} property.
     *
     * @see #logoTopPadding
     */
    public void setLogoTopPadding(double v) {
        setDouble(logoTopPadding, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "navColor"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code navColor} property.
     *
     * @see #getNavColor
     * @see #setNavColor
     */
    public static final Property navColor = newProperty(Flags.SUMMARY, BBrush.makeSolid(BColor.orange), null);

    /**
     * Get the {@code navColor} property.
     *
     * @see #navColor
     */
    public BBrush getNavColor() {
        return (BBrush) get(navColor);
    }

    /**
     * Set the {@code navColor} property.
     *
     * @see #navColor
     */
    public void setNavColor(BBrush v) {
        set(navColor, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasOat"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasOat} property.
     *
     * @see #getHasOat
     * @see #setHasOat
     */
    public static final Property hasOat = newProperty(Flags.SUMMARY, true, null);

    /**
     * Get the {@code hasOat} property.
     *
     * @see #hasOat
     */
    public boolean getHasOat() {
        return getBoolean(hasOat);
    }

    /**
     * Set the {@code hasOat} property.
     *
     * @see #hasOat
     */
    public void setHasOat(boolean v) {
        setBoolean(hasOat, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "oat"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code oat} property.
     *
     * @see #getOat
     * @see #setOat
     */
    public static final Property oat = newProperty(Flags.SUMMARY, "0", null);

    /**
     * Get the {@code oat} property.
     *
     * @see #oat
     */
    public String getOat() {
        return getString(oat);
    }

    /**
     * Set the {@code oat} property.
     *
     * @see #oat
     */
    public void setOat(String v) {
        setString(oat, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasOah"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasOah} property.
     *
     * @see #getHasOah
     * @see #setHasOah
     */
    public static final Property hasOah = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasOah} property.
     *
     * @see #hasOah
     */
    public boolean getHasOah() {
        return getBoolean(hasOah);
    }

    /**
     * Set the {@code hasOah} property.
     *
     * @see #hasOah
     */
    public void setHasOah(boolean v) {
        setBoolean(hasOah, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "oah"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code oah} property.
     *
     * @see #getOah
     * @see #setOah
     */
    public static final Property oah = newProperty(Flags.SUMMARY, "0", null);

    /**
     * Get the {@code oah} property.
     *
     * @see #oah
     */
    public String getOah() {
        return getString(oah);
    }

    /**
     * Set the {@code oah} property.
     *
     * @see #oah
     */
    public void setOah(String v) {
        setString(oah, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "homePagePath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code homePagePath} property.
     *
     * @see #getHomePagePath
     * @see #setHomePagePath
     */
    public static final Property homePagePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Graphics/Home"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));

    /**
     * Get the {@code homePagePath} property.
     *
     * @see #homePagePath
     */
    public BOrd getHomePagePath() {
        return (BOrd) get(homePagePath);
    }

    /**
     * Set the {@code homePagePath} property.
     *
     * @see #homePagePath
     */
    public void setHomePagePath(BOrd v) {
        set(homePagePath, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasEntSec"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasEntSec} property.
     *
     * @see #getHasEntSec
     * @see #setHasEntSec
     */
    public static final Property hasEntSec = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasEntSec} property.
     *
     * @see #hasEntSec
     */
    public boolean getHasEntSec() {
        return getBoolean(hasEntSec);
    }

    /**
     * Set the {@code hasEntSec} property.
     *
     * @see #hasEntSec
     */
    public void setHasEntSec(boolean v) {
        setBoolean(hasEntSec, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasEquipment"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasEquipment} property.
     *
     * @see #getHasEquipment
     * @see #setHasEquipment
     */
    public static final Property hasEquipment = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasEquipment} property.
     *
     * @see #hasEquipment
     */
    public boolean getHasEquipment() {
        return getBoolean(hasEquipment);
    }

    /**
     * Set the {@code hasEquipment} property.
     *
     * @see #hasEquipment
     */
    public void setHasEquipment(boolean v) {
        setBoolean(hasEquipment, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "equipListName"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code equipListName} property.
     *
     * @see #getEquipListName
     * @see #setEquipListName
     */
    public static final Property equipListName = newProperty(Flags.SUMMARY, "Equipment", null);

    /**
     * Get the {@code equipListName} property.
     *
     * @see #equipListName
     */
    public String getEquipListName() {
        return getString(equipListName);
    }

    /**
     * Set the {@code equipListName} property.
     *
     * @see #equipListName
     */
    public void setEquipListName(String v) {
        setString(equipListName, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasFloorplans"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasFloorplans} property.
     *
     * @see #getHasFloorplans
     * @see #setHasFloorplans
     */
    public static final Property hasFloorplans = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasFloorplans} property.
     *
     * @see #hasFloorplans
     */
    public boolean getHasFloorplans() {
        return getBoolean(hasFloorplans);
    }

    /**
     * Set the {@code hasFloorplans} property.
     *
     * @see #hasFloorplans
     */
    public void setHasFloorplans(boolean v) {
        setBoolean(hasFloorplans, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "floorplanListName"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code floorplanListName} property.
     *
     * @see #getFloorplanListName
     * @see #setFloorplanListName
     */
    public static final Property floorplanListName = newProperty(Flags.SUMMARY, "Floorplans", null);

    /**
     * Get the {@code floorplanListName} property.
     *
     * @see #floorplanListName
     */
    public String getFloorplanListName() {
        return getString(floorplanListName);
    }

    /**
     * Set the {@code floorplanListName} property.
     *
     * @see #floorplanListName
     */
    public void setFloorplanListName(String v) {
        setString(floorplanListName, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasCustomNavItem"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasCustomNavItem} property.
     *
     * @see #getHasCustomNavItem
     * @see #setHasCustomNavItem
     */
    public static final Property hasCustomNavItem = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasCustomNavItem} property.
     *
     * @see #hasCustomNavItem
     */
    public boolean getHasCustomNavItem() {
        return getBoolean(hasCustomNavItem);
    }

    /**
     * Set the {@code hasCustomNavItem} property.
     *
     * @see #hasCustomNavItem
     */
    public void setHasCustomNavItem(boolean v) {
        setBoolean(hasCustomNavItem, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "customListName"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code customListName} property.
     *
     * @see #getCustomListName
     * @see #setCustomListName
     */
    public static final Property customListName = newProperty(Flags.SUMMARY, "Custom", null);

    /**
     * Get the {@code customListName} property.
     *
     * @see #customListName
     */
    public String getCustomListName() {
        return getString(customListName);
    }

    /**
     * Set the {@code customListName} property.
     *
     * @see #customListName
     */
    public void setCustomListName(String v) {
        setString(customListName, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasExternalLink"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasExternalLink} property.
     *
     * @see #getHasExternalLink
     * @see #setHasExternalLink
     */
    public static final Property hasExternalLink = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasExternalLink} property.
     *
     * @see #hasExternalLink
     */
    public boolean getHasExternalLink() {
        return getBoolean(hasExternalLink);
    }

    /**
     * Set the {@code hasExternalLink} property.
     *
     * @see #hasExternalLink
     */
    public void setHasExternalLink(boolean v) {
        setBoolean(hasExternalLink, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "externalLinkName"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code externalLinkName} property.
     *
     * @see #getExternalLinkName
     * @see #setExternalLinkName
     */
    public static final Property externalLinkName = newProperty(Flags.SUMMARY, "External Link", null);

    /**
     * Get the {@code externalLinkName} property.
     *
     * @see #externalLinkName
     */
    public String getExternalLinkName() {
        return getString(externalLinkName);
    }

    /**
     * Set the {@code externalLinkName} property.
     *
     * @see #externalLinkName
     */
    public void setExternalLinkName(String v) {
        setString(externalLinkName, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "externalLinkPath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code externalLinkPath} property.
     *
     * @see #getExternalLinkPath
     * @see #setExternalLinkPath
     */
    public static final Property externalLinkPath = newProperty(Flags.SUMMARY, "", null);

    /**
     * Get the {@code externalLinkPath} property.
     *
     * @see #externalLinkPath
     */
    public String getExternalLinkPath() {
        return getString(externalLinkPath);
    }

    /**
     * Set the {@code externalLinkPath} property.
     *
     * @see #externalLinkPath
     */
    public void setExternalLinkPath(String v) {
        setString(externalLinkPath, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "showHistories"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code showHistories} property.
     *
     * @see #getShowHistories
     * @see #setShowHistories
     */
    public static final Property showHistories = newProperty(Flags.SUMMARY, true, null);

    /**
     * Get the {@code showHistories} property.
     *
     * @see #showHistories
     */
    public boolean getShowHistories() {
        return getBoolean(showHistories);
    }

    /**
     * Set the {@code showHistories} property.
     *
     * @see #showHistories
     */
    public void setShowHistories(boolean v) {
        setBoolean(showHistories, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "showSchedules"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code showSchedules} property.
     *
     * @see #getShowSchedules
     * @see #setShowSchedules
     */
    public static final Property showSchedules = newProperty(Flags.SUMMARY, true, null);

    /**
     * Get the {@code showSchedules} property.
     *
     * @see #showSchedules
     */
    public boolean getShowSchedules() {
        return getBoolean(showSchedules);
    }

    /**
     * Set the {@code showSchedules} property.
     *
     * @see #showSchedules
     */
    public void setShowSchedules(boolean v) {
        setBoolean(showSchedules, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "schedulePagePath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code schedulePagePath} property.
     *
     * @see #getSchedulePagePath
     * @see #setSchedulePagePath
     */
    public static final Property schedulePagePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Drivers/Schedules"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));

    /**
     * Get the {@code schedulePagePath} property.
     *
     * @see #schedulePagePath
     */
    public BOrd getSchedulePagePath() {
        return (BOrd) get(schedulePagePath);
    }

    /**
     * Set the {@code schedulePagePath} property.
     *
     * @see #schedulePagePath
     */
    public void setSchedulePagePath(BOrd v) {
        set(schedulePagePath, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "showReports"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code showReports} property.
     *
     * @see #getShowReports
     * @see #setShowReports
     */
    public static final Property showReports = newProperty(Flags.SUMMARY, true, null);

    /**
     * Get the {@code showReports} property.
     *
     * @see #showReports
     */
    public boolean getShowReports() {
        return getBoolean(showReports);
    }

    /**
     * Set the {@code showReports} property.
     *
     * @see #showReports
     */
    public void setShowReports(boolean v) {
        setBoolean(showReports, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "showDocs"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code showDocs} property.
     *
     * @see #getShowDocs
     * @see #setShowDocs
     */
    public static final Property showDocs = newProperty(Flags.SUMMARY, true, null);

    /**
     * Get the {@code showDocs} property.
     *
     * @see #showDocs
     */
    public boolean getShowDocs() {
        return getBoolean(showDocs);
    }

    /**
     * Set the {@code showDocs} property.
     *
     * @see #showDocs
     */
    public void setShowDocs(boolean v) {
        setBoolean(showDocs, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasNotificationConsole"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasNotificationConsole} property.
     *
     * @see #getHasNotificationConsole
     * @see #setHasNotificationConsole
     */
    public static final Property hasNotificationConsole = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasNotificationConsole} property.
     *
     * @see #hasNotificationConsole
     */
    public boolean getHasNotificationConsole() {
        return getBoolean(hasNotificationConsole);
    }

    /**
     * Set the {@code hasNotificationConsole} property.
     *
     * @see #hasNotificationConsole
     */
    public void setHasNotificationConsole(boolean v) {
        setBoolean(hasNotificationConsole, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "notificationCount"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code notificationCount} property.
     *
     * @see #getNotificationCount
     * @see #setNotificationCount
     */
    public static final Property notificationCount = newProperty(Flags.SUMMARY, 0, null);

    /**
     * Get the {@code notificationCount} property.
     *
     * @see #notificationCount
     */
    public double getNotificationCount() {
        return getDouble(notificationCount);
    }

    /**
     * Set the {@code notificationCount} property.
     *
     * @see #notificationCount
     */
    public void setNotificationCount(double v) {
        setDouble(notificationCount, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "notificationConsolePath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code notificationConsolePath} property.
     *
     * @see #getNotificationConsolePath
     * @see #setNotificationConsolePath
     */
    public static final Property notificationConsolePath = newProperty(Flags.SUMMARY, BOrd.make("null"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));

    /**
     * Get the {@code notificationConsolePath} property.
     *
     * @see #notificationConsolePath
     */
    public BOrd getNotificationConsolePath() {
        return (BOrd) get(notificationConsolePath);
    }

    /**
     * Set the {@code notificationConsolePath} property.
     *
     * @see #notificationConsolePath
     */
    public void setNotificationConsolePath(BOrd v) {
        set(notificationConsolePath, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "hasAlarmConsole"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code hasAlarmConsole} property.
     *
     * @see #getHasAlarmConsole
     * @see #setHasAlarmConsole
     */
    public static final Property hasAlarmConsole = newProperty(Flags.SUMMARY, false, null);

    /**
     * Get the {@code hasAlarmConsole} property.
     *
     * @see #hasAlarmConsole
     */
    public boolean getHasAlarmConsole() {
        return getBoolean(hasAlarmConsole);
    }

    /**
     * Set the {@code hasAlarmConsole} property.
     *
     * @see #hasAlarmConsole
     */
    public void setHasAlarmConsole(boolean v) {
        setBoolean(hasAlarmConsole, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "alarmCount"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code alarmCount} property.
     *
     * @see #getAlarmCount
     * @see #setAlarmCount
     */
    public static final Property alarmCount = newProperty(Flags.SUMMARY, 0, null);

    /**
     * Get the {@code alarmCount} property.
     *
     * @see #alarmCount
     */
    public double getAlarmCount() {
        return getDouble(alarmCount);
    }

    /**
     * Set the {@code alarmCount} property.
     *
     * @see #alarmCount
     */
    public void setAlarmCount(double v) {
        setDouble(alarmCount, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "alarmConsolePath"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code alarmConsolePath} property.
     *
     * @see #getAlarmConsolePath
     * @see #setAlarmConsolePath
     */
    public static final Property alarmConsolePath = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Services/AlarmService/AllAlarms"), BFacets.make(BFacets.TARGET_TYPE, "baja:IComponent"));

    /**
     * Get the {@code alarmConsolePath} property.
     *
     * @see #alarmConsolePath
     */
    public BOrd getAlarmConsolePath() {
        return (BOrd) get(alarmConsolePath);
    }

    /**
     * Set the {@code alarmConsolePath} property.
     *
     * @see #alarmConsolePath
     */
    public void setAlarmConsolePath(BOrd v) {
        set(alarmConsolePath, v, null);
    }

////////////////////////////////////////////////////////////////
// Action "generateHTML"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code generateHTML} action.
     *
     * @see #generateHTML()
     */
    public static final Action generateHTML = newAction(0, null);

    /**
     * Invoke the {@code generateHTML} action.
     *
     * @see #generateHTML
     */
    public void generateHTML() {
        invoke(generateHTML, null, null);
    }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BHTML5.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


    public void doGenerateHTML() {

        String htmlFolder = getHtmlFolder().toString();
        setEquipHTML(BOrd.make(htmlFolder + "/equip.html"));
        setCustomHTML(BOrd.make(htmlFolder + "/customNav.html"));
        setExternalHTML(BOrd.make(htmlFolder + "/external.html"));
        setFloorplanHTML(BOrd.make(htmlFolder + "/floorplans.html"));
        setIndexHTML(BOrd.make(htmlFolder + "/index.html"));

        setNavFile(BOrd.make(htmlFolder + "/nav/nav.nav"));

        setBajascriptJs(BOrd.make(htmlFolder + "/js/bajascript.js"));
        setScriptJS(BOrd.make(htmlFolder + "/js/script.js"));

        setLogoCSS(BOrd.make(htmlFolder + "/css/logo.css"));
        setNavCSS(BOrd.make(htmlFolder + "/css/nav.css"));
        setStyleCSS(BOrd.make(htmlFolder + "/css/style.css"));

        Date date = new Date();
        System.out.println("HTML Generation started at: " + date);

        BOrd fileOrd = getEquipHTML();

        BIFile file = null;

        String equipMenuName = getEquipListName();


        if (getHasEquipment() == true) {
            if (this.getSlot("EquipmentList") == null) {
                this.add("EquipmentList", new BEquipmentList());
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries = fileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" class><a href='#'><span>" + equipMenuName + " ▼</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + fileOrd.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd.toString());
            }


            // Query for sensor components
            String parentName = getName();

            BOrd query = BOrd.make("station:|slot:/|bql:select equipName, equipPath from nTools:EquipmentNavItem where parent.parent.name = '" + parentName + "'");
            String equipNavName = "";
            String equipPath = "";


            //attempt to locate the file
            try {
                file = (BIFile) fileOrd.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection

            BITable table = (BITable) query.get();
            ColumnList columns = table.getColumns();

            try (TableCursor<BIObject> cursor = table.cursor()) {
                int row = 0;
                while (cursor.next()) {


                    equipNavName = (cursor.cell(columns.get(0)).toString());
                    equipPath = (cursor.cell(columns.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath = file.getFilePath();
                        File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                        FileWriter fw = new FileWriter(localFile, true);
                        fw.write("<li><a target=\"hx\" href='" + equipPath + "'>");
                        fw.write("<span>" + equipNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("EquipmentList") != null) {
                this.remove("EquipmentList");
            }

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries = fileOrd.parse();
                FilePath filePath = (FilePath) queries[queries.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file = BFileSystem.INSTANCE.makeFile(filePath);
                File localFile = BFileSystem.INSTANCE.pathToLocalFile(filePath);
                FileWriter fw = new FileWriter(localFile, false);
                fw.write("<li id=\"equipMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + fileOrd.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd.toString());

            }
        }


        BOrd fileOrd2 = getCustomHTML();
        BIFile file2 = null;
        String customMenuName = getCustomListName();


        if (getHasCustomNavItem() == true) {
            if (this.getSlot("CustomList") == null) {
                this.add("CustomList", new BCustomList());
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" class><a href='#'><span>" + customMenuName + " ▼</span></a><ul>");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd2.toString());

            }

            // Query for sensor components
            String parentName = getName();

            BOrd query2 = BOrd.make("station:|slot:/|bql:select customItemName, customItemPath from nTools:CustomNavItem where parent.parent.name = '" + parentName + "'");
            String customNavName = "";
            String customPath = "";


            //attempt to locate the file
            try {
                file2 = (BIFile) fileOrd2.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection

            BITable table2 = (BITable) query2.get();
            ColumnList columns2 = table2.getColumns();

            try (TableCursor<BIObject> cursor2 = table2.cursor()) {
                int row = 0;
                while (cursor2.next()) {


                    customNavName = (cursor2.cell(columns2.get(0)).toString());
                    customPath = (cursor2.cell(columns2.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath2 = file2.getFilePath();
                        File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                        FileWriter fw = new FileWriter(localFile2, true);
                        fw.write("<li><a target=\"hx\" href='" + customPath + "'>");
                        fw.write("<span>" + customNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd2.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("CustomList") != null) {
                this.remove("CustomList");
            }
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries2 = fileOrd2.parse();
                FilePath filePath2 = (FilePath) queries2[queries2.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file2 = BFileSystem.INSTANCE.makeFile(filePath2);
                File localFile2 = BFileSystem.INSTANCE.pathToLocalFile(filePath2);
                FileWriter fw = new FileWriter(localFile2, false);
                fw.write("<li id=\"customMenu\" style=\"display:none;\"");
                fw.close();
                System.out.println("Success writing to " + fileOrd2.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd2.toString());

            }
        }

        BOrd fileOrd3 = getFloorplanHTML();
        BIFile file3 = null;
        String floorplanMenuName = getFloorplanListName();


        if (getHasFloorplans() == true) {
            if (this.getSlot("FloorplanList") == null) {
                this.add("FloorplanList", new BFloorplanList());
            }

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" class><a href='#'><span>" + floorplanMenuName + " ▼</span></a><ul>");

                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault

                System.out.println("Error writing to " + fileOrd3.toString());

            }

            // Query for sensor components
            String parentName = getName();
            BOrd query3 = BOrd.make("station:|slot:/|bql:select floorplanName, floorplanPath from nTools:FloorplanNavItem where parent.parent.name = '" + parentName + "'");
            String floorplanNavName = "";
            String floorplanPath = "";


            //attempt to locate the file
            try {
                file3 = (BIFile) fileOrd3.get(this);
            } catch (UnresolvedException e) {
                //do nothing
            }
            // Resolve our query to a Cursor and iterate through our
            // collection
            BITable table3 = (BITable) query3.get();
            ColumnList columns3 = table3.getColumns();


            try (TableCursor<BIObject> cursor3 = table3.cursor()) {
                int row = 0;
                while (cursor3.next()) {


                    floorplanNavName = (cursor3.cell(columns3.get(0)).toString());
                    floorplanPath = (cursor3.cell(columns3.get(1)).toString());

                    try {
                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        FilePath filePath3 = file3.getFilePath();
                        File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                        FileWriter fw = new FileWriter(localFile3, true);
                        fw.write("<li><a target=\"hx\" href='" + floorplanPath + "'>");
                        fw.write("<span>" + floorplanNavName + "</span></a></li>");
                        fw.close();
                        System.out.println("Success writing to " + fileOrd3.toString());

                    }
                    //handle case where file isn't found or doesn't exist.
                    catch (UnresolvedException re) {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch (IOException ioe) {

                    }

                }
                ++row;

            }
        } else {
            if (this.getSlot("FloorplanList") != null) {
                this.remove("FloorplanList");
            }


            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries3 = fileOrd3.parse();
                FilePath filePath3 = (FilePath) queries3[queries3.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file3 = BFileSystem.INSTANCE.makeFile(filePath3);
                File localFile3 = BFileSystem.INSTANCE.pathToLocalFile(filePath3);
                FileWriter fw = new FileWriter(localFile3, false);
                fw.write("<li id=\"floorplanMenu\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd3.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd3.toString());
            }


        }


        BOrd fileOrd5 = getLogoCSS();
        BIFile file5 = null;
        double minWidth = getMinLogoWidth();
        double maxWidth = getMaxLogoWidth();
        double topPadding = getLogoTopPadding();


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries5 = fileOrd5.parse();
            FilePath filePath5 = (FilePath) queries5[queries5.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file5 = BFileSystem.INSTANCE.makeFile(filePath5);
            File localFile5 = BFileSystem.INSTANCE.pathToLocalFile(filePath5);
            FileWriter fw = new FileWriter(localFile5, false);
            fw.write("#logo{width: 100%;max-width:" + maxWidth + "px;min-width:" + minWidth + "px;margin-top:" + topPadding + "px;}");
            fw.close();
            System.out.println("Success writing to " + fileOrd5.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault

            System.out.println("Error writing to " + fileOrd5.toString());

        }

        BOrd fileOrd6 = getNavCSS();
        BIFile file6 = null;
        String navColor = getNavColor().toString();


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries6 = fileOrd6.parse();
            FilePath filePath6 = (FilePath) queries6[queries6.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file6 = BFileSystem.INSTANCE.makeFile(filePath6);
            File localFile6 = BFileSystem.INSTANCE.pathToLocalFile(filePath6);
            FileWriter fw = new FileWriter(localFile6, false);
            fw.write("#cssmenu{background:" + navColor + "}");
            fw.close();
            System.out.println("Success writing to " + fileOrd6.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault

            System.out.println("Error writing to " + fileOrd6.toString());

        }


        BOrd fileOrd9 = getExternalHTML();
        BIFile file9 = null;
        String externalPath = getExternalLinkPath();
        String externalLinkName = getExternalLinkName();


        if (getHasExternalLink() == true) {

            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" class><a target=\"_blank\" href='" + externalPath + "'><span>" + externalLinkName + "</span></a><ul >");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        } else {
            try { // Parse the file ORD to retrieve the FilePath. We can safely
                // assume the FilePath is the last sub query of the full ORD.
                OrdQuery[] queries9 = fileOrd9.parse();
                FilePath filePath9 = (FilePath) queries9[queries9.length - 1];
                // Once we have the FilePath, we use it to create the file.
                // Niagara provides a BFileSystem space which gives us access
                // to the local file system where we create the file:
                file9 = BFileSystem.INSTANCE.makeFile(filePath9);
                File localFile9 = BFileSystem.INSTANCE.pathToLocalFile(filePath9);
                FileWriter fw = new FileWriter(localFile9, false);
                fw.write("<li id=\"externalLink\" style=\"display:none;\"</li>");
                fw.close();
                System.out.println("Success writing to " + fileOrd9.toString());


            } catch (Exception e) // Indicates problem creating file
            { // Call configFail() to set the service into fault
                System.out.println("Error writing to " + fileOrd9.toString());
            }
        }


        BOrd fileOrd13 = getNavFile();
        BIFile file13 = null;


        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries13 = fileOrd13.parse();
            FilePath filePath13 = (FilePath) queries13[queries13.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file13 = BFileSystem.INSTANCE.makeFile(filePath13);
            File localFile13 = BFileSystem.INSTANCE.pathToLocalFile(filePath13);
            FileWriter fw = new FileWriter(localFile13, false);
            fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <nav version='1.0'> <node name='Home' ord='" + htmlFolder + "/index.html|view:web:FileDownloadView' icon='module://icons/x16/folder.png'/></nav>");
            fw.close();
            System.out.println("Success writing to " + fileOrd13.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault
            System.out.println("Error writing to " + fileOrd13.toString());
        }

        BOrd fileOrd14 = getBajascriptJs();
        BIFile file14 = null;
        String serviceName = getName();

        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries14 = fileOrd14.parse();
            FilePath filePath14 = (FilePath) queries14[queries14.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file14 = BFileSystem.INSTANCE.makeFile(filePath14);
            File localFile14 = BFileSystem.INSTANCE.pathToLocalFile(filePath14);
            FileWriter fw = new FileWriter(localFile14, false);
            fw.write("\n" +
                    " require([\"baja!\"], function (baja) {\"use strict\";\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        var allAlarmSub = new baja.Subscriber(); \n" +
                    "        \n" +
                    "            allAlarmSub.attach(\"changed\", function(prop) {\n" +
                    "            \n" +
                    "            document.getElementById(\"AllAlarms\").innerHTML = \"All Alarms (\" + this.getAlarmCount() + \")\";\n" +
                    "              \n" +
                    "                  var val = this.getAlarmCount();\n" +
                    "                  \n" +
                    "                 if (val > 0.5){\n" +
                    "                document.getElementById(\"AllAlarms\").style=\"animation:alarm 2.5s infinite;\"\n" +
                    "            }\n" +
                    "            else {\n" +
                    "                                document.getElementById(\"AllAlarms\").style=\"animation:none;\"\n" +
                    "\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "            });\n" +
                    "             //this is the link to the alarm count on the alarm service wiresheet, either name it AllAlarms or copy your name here\n" +
                    "            baja.Ord.make(\"station:|slot:/Services/" + serviceName + "\").get({\n" +
                    "               subscriber: allAlarmSub\n" +
                    "            });\n" +
                    "            \n" +
                    "            var allNotifSub = new baja.Subscriber(); \n" +
                    "        \n" +
                    "            allNotifSub.attach(\"changed\", function(prop) {\n" +
                    "            \n" +
                    "            document.getElementById(\"AllNotifications\").innerHTML = \"All Notifications (\" + this.getNotificationCount() + \")\";\n" +
                    "                  var val = this.getNotificationCount();\n" +
                    "                  \n" +
                    "                 if (val > 0.5){\n" +
                    "                document.getElementById(\"AllNotifications\").style=\"animation:notification 2.5s infinite;\"\n" +
                    "            }\n" +
                    "            else {\n" +
                    "                                document.getElementById(\"AllNotifications\").style=\"animation:none;\"\n" +
                    "\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "\n" +
                    "            });\n" +
                    "             //this is the link to the alarm count on the alarm service wiresheet, either name it AllAlarms or copy your name here\n" +
                    "            baja.Ord.make(\"station:|slot:/Services/" + serviceName + "\").get({\n" +
                    "               subscriber: allNotifSub\n" +
                    "            });\n" +
                    "            \n" +
                    "            \n" +
                    "            var oatSub = new baja.Subscriber(); \n" +
                    "\n" +
                    "            oatSub.attach(\"changed\", function(prop) {\n" +
                    "              \n" +
                    "               \n" +
                    "            \n" +
                    "            document.getElementById(\"temp\").innerHTML =\"Outdoor Temp: \" + this.getOat() + \" °F\";\n" +
                    "           var hasOAT = this.getHasOat();\n" +
                    "            \n" +
                    "            if (hasOAT == true){\n" +
                    "                        document.getElementById(\"temp\").style =\"display:inline;\";\n" +
                    "            }\n" +
                    "            else{\n" +
                    "            document.getElementById(\"temp\").style =\"display:none;\";\n" +
                    "\n" +
                    "}\n" +
                    "            });\n" +
                    "             //this is the link to the OAT, copy your ORD here\n" +
                    "            baja.Ord.make(\"station:|slot:/Services/" + serviceName + "\").get({\n" +
                    "               subscriber: oatSub\n" +
                    "            });\n" +
                    "            \n" +
                    "                 \n" +
                    "            var oahSub = new baja.Subscriber(); \n" +
                    "        \n" +
                    "            oahSub.attach(\"changed\", function(prop) {\n" +
                    "            \n" +
                    "            document.getElementById(\"humid\").innerHTML =\"Outdoor Humidity: \" + this.getOah() + \" %\";\n" +
                    "            \n" +
                    "            var hasOAH = this.getHasOah();\n" +
                    "            \n" +
                    "            if (hasOAH == true){\n" +
                    "                        document.getElementById(\"humid\").style =\"display:inline;\";\n" +
                    "            }\n" +
                    "            else{\n" +
                    "            document.getElementById(\"humid\").style =\"display:none;\";\n" +
                    "\n" +
                    "}\n" +
                    "           \n" +
                    "            });\n" +
                    "             //this is the link to the OAH, copy your ORD here\n" +
                    "            baja.Ord.make(\"station:|slot:/Services/" + serviceName + "\").get({\n" +
                    "               subscriber: oahSub\n" +
                    "            });\n" +
                    "            \n" +
                    "            \n" +
                    "           \n" +
                    "            \n" +
                    "            \n" +
                    "            \n" +
                    "            \n" +
                    "     //get username & append to header\n" +
                    "    $(\".header-info-username\").empty().append(baja.getUserName());\n" +
                    "    $(\"#header-info-arrow-down\").on(\"click\", function () {\n" +
                    "     $(\"#header-info-arrow-down\").css( \"display\", \"none\" );\n" +
                    "     $(\"#header-info-arrow-up\").css( \"display\", \"table-cell\" );\n" +
                    "     $(\".header-info-username\").animate({top: \"-100%\"}, 150, function() {\n" +
                    "      $(\".header-info-logout\").animate({top: 20}, 150);\n" +
                    "     });\n" +
                    "    });\n" +
                    "    //logoff code\n" +
                    "    $(\"#header-info-arrow-up\").on(\"click\", function () {\n" +
                    "     $(\"#header-info-arrow-up\").css( \"display\", \"none\" );\n" +
                    "     $(\"#header-info-arrow-down\").css( \"display\", \"table-cell\" );\n" +
                    "     $(\".header-info-logout\").animate({top: \"-100%\"}, 150, function() {\n" +
                    "      $(\".header-info-username\").animate({top: 20}, 150);\n" +
                    "     });\n" +
                    "     });\n" +
                    "    \n" +
                    "      baja.start();\n" +
                    "\n" +
                    "      });\n" +
                    " \n" +
                    " \n" +
                    "\n");
            fw.close();
            System.out.println("Success writing to " + fileOrd14.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault
            System.out.println("Error writing to " + fileOrd14.toString());
        }

        BOrd fileOrd15 = getIndexHTML();
        BIFile file15 = null;
        String schedulePath = null;
        String logoPath = getLogoPath().toString();
        String siteTitle = getSiteTitle();
        String homePagePath = getHomePagePath().toString();
        String alarmConsolePath = getAlarmConsolePath().toString();
        String notifConsolePath = getNotificationConsolePath().toString();
        String entSecMenu = "";
        String docMenu = "";
        String reportMenu = "";
        String historiesMenu = "";
        String schedulesMenu = "";
        String notificationMenu = "";
        String alarmMenu = "";


        if (getHasEntSec() == true) {
            schedulePath = "station:|slot:/Services/EnterpriseSecurityService/schedules";
            entSecMenu = "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService'><span>Access Control ▼</span></a><ul><li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/personnel'><span>People</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/badges'><span>Badges</span></a></li><li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/accessRights'><span>Access Rights</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Services/AccessControlService/accessHistory'><span>Access History</span></a></li></ul></li>";
        } else {
            schedulePath = getSchedulePagePath().toString();
            entSecMenu = "";
        }
        if (getShowDocs() == true) {
            docMenu = "<li><a target=\"hx\" href='file:^docs'><span>Documents</span></a></li>";
        } else {
            docMenu = "";
        }
        if (getShowReports() == true) {
            reportMenu = "<li class><a href='#'><span>Reports ▼</span></a><ul> <li class><a target=\"hx\" href='station:|slot:/Graphics/Reports/Active$20Overrides'><span>Active Overrides</span></a></li>" +
                    "<li class><a target=\"hx\" href='station:|slot:/Graphics/Reports/Override$20Report$20$28last$207$20days$29'><span>Audit Log (last 7 days)</span></a></li></ul></li>";
        } else {
            reportMenu = "";
        }
        if (getShowHistories() == true) {
            historiesMenu = "<li><a target=\"hx\" href='history:|view:webChart:ChartWidget'><span>Histories</span></a></li>";
        } else {
            historiesMenu = "";
        }
        if (getShowSchedules() == true) {
            schedulesMenu = "<li class><a target=\"hx\" href='" + schedulePath + "'><span>Schedules</span></a></li>";
        } else {
            schedulesMenu = "";
        }
        if (getHasNotificationConsole() == true) {
            notificationMenu = "<li id=\"Notifications\"><a id=\"NotificationConsoleLink\" target=\"hx\" href=\"" + notifConsolePath + "\"><span id=\"AllNotifications\" class=\"AllNotifications\" >Notification Count loading..</span></a></li>";
        } else {
            notificationMenu = "";
        }
        if (getHasAlarmConsole() == true) {
            alarmMenu = "<li class='last' id=\"Alarms\"><a id=\"AlarmConsoleLink\" target=\"hx\" href=\"" + alarmConsolePath + "\"><span id=\"AllAlarms\" class=\"AllAlarms\" >Alarm Count loading..</span></a></li>";
        } else {
            alarmMenu = "";
        }




        BOrd fileOrd16 = getScriptJS();
        BIFile file16 = null;

        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries16 = fileOrd16.parse();
            FilePath filePath16 = (FilePath) queries16[queries16.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file16 = BFileSystem.INSTANCE.makeFile(filePath16);
            File localFile16 = BFileSystem.INSTANCE.pathToLocalFile(filePath16);
            FileWriter fw = new FileWriter(localFile16, false);
            fw.write("\n" +
                    "( function( $ ) {\n" +
                    "$( document ).ready(function() {\n" +
                    "$('#cssmenu').prepend('<div id=\"menu-button\">Menu</div>');\n" +
                    " $('#cssmenu #menu-button').on('click', function(){\n" +
                    "  var menu = $(this).next('ul');\n" +
                    "  if (menu.hasClass('open')) {\n" +
                    "   menu.removeClass('open');\n" +
                    "  }\n" +
                    "  else {\n" +
                    "   menu.addClass('open');\n" +
                    "  }\n" +
                    " });\n" +
                    "  $('#cssmenu ul').on('click', 'a', function(){\n" +
                    "  var menu = $('#cssmenu #menu-button').next('ul');\n" +
                    "  if (menu.hasClass('open')) {\n" +
                    "   menu.removeClass('open');\n" +
                    "  }\n" +
                    "  else {\n" +
                    "   menu.addClass('open');\n" +
                    "  }\n" +
                    " });\n" +
                    " $('#cssmenu ul ul').on('click', 'a', function(){\n" +
                    "  var menu = $('#cssmenu #menu-button').next('ul');\n" +
                    "  if (menu.hasClass('open')) {\n" +
                    "   menu.removeClass('open');\n" +
                    "  }\n" +
                    "  else {\n" +
                    "   menu.addClass('open');\n" +
                    "  }\n" +
                    " });\n" +
                    "});\n" +
                    "} )( jQuery );\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n");
            fw.close();
            System.out.println("Success writing to " + fileOrd16.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault
            System.out.println("Error writing to " + fileOrd16.toString());
        }
        BOrd fileOrd17 = getStyleCSS();
        BIFile file17 = null;

        try { // Parse the file ORD to retrieve the FilePath. We can safely
            // assume the FilePath is the last sub query of the full ORD.
            OrdQuery[] queries17 = fileOrd17.parse();
            FilePath filePath17 = (FilePath) queries17[queries17.length - 1];
            // Once we have the FilePath, we use it to create the file.
            // Niagara provides a BFileSystem space which gives us access
            // to the local file system where we create the file:
            file17 = BFileSystem.INSTANCE.makeFile(filePath17);
            File localFile17 = BFileSystem.INSTANCE.pathToLocalFile(filePath17);
            FileWriter fw = new FileWriter(localFile17, false);
            fw.write(".iframe-container {\n" +
                    "  overflow: hidden;\n" +
                    "  padding-top: 49.5%;\n" +
                    "  position: relative;\n" +
                    "  z-index: 1;\n" +
                    "}\n" +
                    " \n" +
                    ".iframe-container iframe {\n" +
                    "   border: 0;\n" +
                    "   height: 100%;\n" +
                    "   left: 0;\n" +
                    "   position: absolute;\n" +
                    "   top: 0;\n" +
                    "   width: 100%;\n" +
                    "}\n" +
                    "/* 4x3 Aspect Ratio */\n" +
                    ".iframe-container-4x3 {\n" +
                    "  padding-top: 75%;\n" +
                    "}\n" +
                    "\n" +
                    "body {\n" +
                    "overflow-y: auto;\n" +
                    "overflow-x: auto;\n" +
                    "}\n" +
                    "\n" +
                    "iframe {\n" +
                    "overflow-y:auto;\n" +
                    "overflow-x:auto;\n" +
                    "}\n" +
                    "/*Generally everything below this point should work out of the box and not need to be changed*/\n" +
                    "\n" +
                    "/*navbar*/\n" +
                    "\n" +
                    "#cssmenu,\n" +
                    "#cssmenu ul,\n" +
                    "#cssmenu ul li,\n" +
                    "#cssmenu ul li a,\n" +
                    "#cssmenu #menu-button {\n" +
                    "  margin: 0;\n" +
                    "  padding: 0;\n" +
                    "  border: 0;\n" +
                    "  list-style: none;\n" +
                    "  line-height: 1;\n" +
                    "  display: block;\n" +
                    "  position: relative;\n" +
                    "  -webkit-box-sizing: border-box;\n" +
                    "  -moz-box-sizing: border-box;\n" +
                    "  box-sizing: border-box;\n" +
                    "  z-index: 2;\n" +
                    "  \n" +
                    "}\n" +
                    "#cssmenu:after,\n" +
                    "#cssmenu > ul:after {\n" +
                    "  content: \".\";\n" +
                    "  display: block;\n" +
                    "  clear: both;\n" +
                    "  visibility: hidden;\n" +
                    "  line-height: 0;\n" +
                    "  height: 0;\n" +
                    "}\n" +
                    "#cssmenu #menu-button {\n" +
                    "  display: none;\n" +
                    "}\n" +
                    "#cssmenu {\n" +
                    "  width: auto;\n" +
                    "  font-family:Helvetica, sans-serif;\n" +
                    "  background: #de851a;\n" +
                    "  background: -moz-linear-gradient(top, #de851a 0%, #F7941D 100%);\n" +
                    "  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #de851a), color-stop(100%, #F7941D));\n" +
                    "  background: -webkit-linear-gradient(top, #de851a 0%, #F7941D 100%);\n" +
                    "  background: -o-linear-gradient(top, #de851a 0%, #F7941D 100%);\n" +
                    "  background: -ms-linear-gradient(top, #de851a 0%, #F7941D 100%);\n" +
                    "  background: linear-gradient(to bottom, #de851a 0%, #F7941D 100%);\n" +
                    "}\n" +
                    "#cssmenu > ul {\n" +
                    "  background: url('file:^graphics/images/bg.png');\n" +
                    "  box-shadow: inset 0 -3px 0 rgba(0, 0, 0, 0.05);\n" +
                    "}\n" +
                    "#cssmenu.align-right > ul > li {\n" +
                    "  float: right;\n" +
                    "}\n" +
                    "#cssmenu > ul > li {\n" +
                    "  float: left;\n" +
                    "  display: inline-block;\n" +
                    "}\n" +
                    "#cssmenu.align-center > ul {\n" +
                    "  float: none;\n" +
                    "  text-align: center;\n" +
                    "}\n" +
                    "#cssmenu.align-center > ul > li {\n" +
                    "  float: none;\n" +
                    "}\n" +
                    "#cssmenu.align-center ul ul {\n" +
                    "  text-align: left;\n" +
                    "}\n" +
                    "#cssmenu > ul > li > a {\n" +
                    "  padding: 18px 25px 21px 25px;\n" +
                    "  border-right: 1px solid rgba(80, 80, 80, 0.12);\n" +
                    "  text-decoration: none;\n" +
                    "  font-size: 15px;\n" +
                    "  font-weight: 700;\n" +
                    "  color: #fff;\n" +
                    "  text-shadow:\n" +
                    "   -1px -1px 0 #606060;\n" +
                    "}\n" +
                    "#cssmenu > ul > li:hover > a,\n" +
                    "#cssmenu > ul > li > a:hover,\n" +
                    "#cssmenu > ul > li.active > a {\n" +
                    "  color: #ffffff;\n" +
                    "  background: #F7941D;\n" +
                    "  background: rgba(200, 200, 200, 0.4);\n" +
                    "}\n" +
                    "#cssmenu > ul > li.has-sub > a {\n" +
                    "  padding-right: 45px;\n" +
                    "}\n" +
                    "#cssmenu > ul > li.has-sub > a::after {\n" +
                    " \n" +
                    "  position: absolute;\n" +
                    "  width: 0;\n" +
                    "  height: 0;\n" +
                    "  border: 6px solid transparent;\n" +
                    "  border-top-color: #fff;\n" +
                    "  right: 17px;\n" +
                    "  top: 22px;\n" +
                    "}\n" +
                    "#cssmenu > ul > li.has-sub.active > a::after,\n" +
                    "#cssmenu > ul > li.has-sub:hover > a {\n" +
                    "  border-top-color: #ffffff;\n" +
                    "}\n" +
                    "#cssmenu ul ul {\n" +
                    "  position: absolute;\n" +
                    "  left: -9999px;\n" +
                    "  top: 60px;\n" +
                    "  padding-top: 6px;\n" +
                    "  font-size: 13px;\n" +
                    "  opacity: 0;\n" +
                    "  -webkit-transition: top 0.2s ease, opacity 0.2s ease-in;\n" +
                    "  -moz-transition: top 0.2s ease, opacity 0.2s ease-in;\n" +
                    "  -ms-transition: top 0.2s ease, opacity 0.2s ease-in;\n" +
                    "  -o-transition: top 0.2s ease, opacity 0.2s ease-in;\n" +
                    "  transition: top 0.2s ease, opacity 0.2s ease-in;\n" +
                    "  \n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul {\n" +
                    "  text-align: right;\n" +
                    "}\n" +
                    "#cssmenu > ul > li > ul::after {\n" +
                    "  content: \"\";\n" +
                    "  position: absolute;\n" +
                    "  width: 0;\n" +
                    "  height: 0;\n" +
                    "  border: 5px solid transparent;\n" +
                    "  border-bottom-color: #ffffff;\n" +
                    "  top: -4px;\n" +
                    "  left: 20px;\n" +
                    "}\n" +
                    "#cssmenu.align-right > ul > li > ul::after {\n" +
                    "  left: auto;\n" +
                    "  right: 20px;\n" +
                    "}\n" +
                    "#cssmenu ul ul ul::after {\n" +
                    "  content: \"\";\n" +
                    "  position: absolute;\n" +
                    "  width: 0;\n" +
                    "  height: 0;\n" +
                    "  border: 5px solid transparent;\n" +
                    "  border-right-color: #ffffff;\n" +
                    "  top: 11px;\n" +
                    "  left: -4px;\n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul ul::after {\n" +
                    "  border-right-color: transparent;\n" +
                    "  border-left-color: #ffffff;\n" +
                    "  left: auto;\n" +
                    "  right: -4px;\n" +
                    "}\n" +
                    "#cssmenu > ul > li > ul {\n" +
                    "  top: 120px;\n" +
                    "}\n" +
                    "#cssmenu > ul > li:hover > ul {\n" +
                    "  top: 52px;\n" +
                    "  left: 0;\n" +
                    "  opacity: 1;\n" +
                    "}\n" +
                    "#cssmenu.align-right > ul > li:hover > ul {\n" +
                    "  left: auto;\n" +
                    "  right: 0;\n" +
                    "}\n" +
                    "#cssmenu ul ul ul {\n" +
                    "  padding-top: 0;\n" +
                    "  padding-left: 6px;\n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul ul {\n" +
                    "  padding-right: 6px;\n" +
                    "}\n" +
                    "#cssmenu ul ul > li:hover > ul {\n" +
                    "  left: 180px;\n" +
                    "  top: 0;\n" +
                    "  opacity: 1;\n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul > li:hover > ul {\n" +
                    "  left: auto;\n" +
                    "  right: 100%;\n" +
                    "  opacity: 1;\n" +
                    "}\n" +
                    "#cssmenu ul ul li a {\n" +
                    "  text-decoration: none;\n" +
                    "  font-weight: 400;\n" +
                    "  padding: 11px 25px;\n" +
                    "  width: 180px;\n" +
                    "  color: #606060;\n" +
                    "  background: #e9eaea;\n" +
                    "  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1), 1px 1px 1px rgba(0, 0, 0, 0.1), -1px 1px 1px rgba(0, 0, 0, 0.1);\n" +
                    "  \n" +
                    "}\n" +
                    "#cssmenu ul ul li:hover > a,\n" +
                    "#cssmenu ul ul li.active > a {\n" +
                    "   \n" +
                    "  font-weight: bold;\n" +
                    "}\n" +
                    "#cssmenu ul ul li:first-child > a {\n" +
                    "  border-top-left-radius: 3px;\n" +
                    "  border-top-right-radius: 3px;\n" +
                    "}\n" +
                    "#cssmenu ul ul li:last-child > a {\n" +
                    "  border-bottom-left-radius: 3px;\n" +
                    "  border-bottom-right-radius: 3px;\n" +
                    "}\n" +
                    "#cssmenu > ul > li > ul::after {\n" +
                    "  position: absolute;\n" +
                    "  display: block;\n" +
                    "}\n" +
                    "#cssmenu ul ul li.has-sub > a::after {\n" +
                    "  content: \"\";\n" +
                    "  position: absolute;\n" +
                    "  width: 0;\n" +
                    "  height: 0;\n" +
                    "  border: 4px solid transparent;\n" +
                    "  border-left-color: #777777;\n" +
                    "  right: 17px;\n" +
                    "  top: 14px;\n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul li.has-sub > a::after {\n" +
                    "  border-left-color: transparent;\n" +
                    "  border-right-color: #777777;\n" +
                    "  right: auto;\n" +
                    "  left: 17px;\n" +
                    "}\n" +
                    "#cssmenu ul ul li.has-sub.active > a::after,\n" +
                    "#cssmenu ul ul li.has-sub:hover > a::after {\n" +
                    "  border-left-color: #333333;\n" +
                    "}\n" +
                    "#cssmenu.align-right ul ul li.has-sub.active > a::after,\n" +
                    "#cssmenu.align-right ul ul li.has-sub:hover > a::after {\n" +
                    "  border-right-color: #333333;\n" +
                    "  border-left-color: transparent;\n" +
                    "}\n" +
                    "/*navbar*/\n" +
                    "@media all and (max-width: 800px), only screen and (-webkit-min-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (min--moz-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (-o-min-device-pixel-ratio: 2/1) and (max-width: 1024px), only screen and (min-device-pixel-ratio: 2) and (max-width: 1024px), only screen and (min-resolution: 192dpi) and (max-width: 1024px), only screen and (min-resolution: 2dppx) and (max-width: 1024px) {\n" +
                    "  \n" +
                    ".iframe-container {\n" +
                    "  overflow: hidden;\n" +
                    "  padding-top: 150%;\n" +
                    "  position: relative;\n" +
                    "}\n" +
                    " \n" +
                    ".iframe-container iframe {\n" +
                    "   border: 0;\n" +
                    "   height: 100%;\n" +
                    "   left: 0;\n" +
                    "   position: absolute;\n" +
                    "   top: 0;\n" +
                    "   width: 100%;\n" +
                    "}\n" +
                    "/* 4x3 Aspect Ratio */\n" +
                    ".iframe-container-4x3 {\n" +
                    "  padding-top: 75%;\n" +
                    "}\n" +
                    "\n" +
                    "#cssmenu {\n" +
                    "    background: #de851a;\n" +
                    "  }\n" +
                    "  #cssmenu > ul {\n" +
                    "    display: none;\n" +
                    "  }\n" +
                    "  #cssmenu > ul.open {\n" +
                    "    display: block;\n" +
                    "    border-top: 1px solid rgba(0, 0, 0, 0.1);\n" +
                    "  }\n" +
                    "  #cssmenu.align-right > ul {\n" +
                    "    float: none;\n" +
                    "  }\n" +
                    "  #cssmenu.align-center > ul {\n" +
                    "    text-align: left;\n" +
                    "  }\n" +
                    "  #cssmenu > ul > li,\n" +
                    "  #cssmenu.align-right > ul > li {\n" +
                    "    float: none;\n" +
                    "    display: block;\n" +
                    "  }\n" +
                    "  #cssmenu > ul > li > a {\n" +
                    "    padding: 18px 25px 18px 25px;\n" +
                    "    border-right: 0;\n" +
                    "  }\n" +
                    "  #cssmenu > ul > li:hover > a,\n" +
                    "  #cssmenu > ul > li.active > a {\n" +
                    "    background: rgba(0, 0, 0, 0.1);\n" +
                    "  }\n" +
                    "  #cssmenu #menu-button {\n" +
                    "    display: block;\n" +
                    "    text-decoration: none;\n" +
                    "    font-size: 13px;\n" +
                    "    font-weight: 700;\n" +
                    "    color: #fff;\n" +
                    "    padding: 18px 25px 18px 25px;\n" +
                    "    text-transform: uppercase;\n" +
                    "    letter-spacing: 1px;\n" +
                    "    background: url('file:^graphics/images/bg.png');\n" +
                    "    cursor: pointer;\n" +
                    "  }\n" +
                    "  #cssmenu ul ul,\n" +
                    "  #cssmenu ul li:hover > ul,\n" +
                    "  #cssmenu > ul > li > ul,\n" +
                    "  #cssmenu ul ul ul,\n" +
                    "  #cssmenu ul ul li:hover > ul,\n" +
                    "  #cssmenu.align-right ul ul,\n" +
                    "  #cssmenu.align-right ul li:hover > ul,\n" +
                    "  #cssmenu.align-right > ul > li > ul,\n" +
                    "  #cssmenu.align-right ul ul ul,\n" +
                    "  #cssmenu.align-right ul ul li:hover > ul {\n" +
                    "    left: 0;\n" +
                    "    right: auto;\n" +
                    "    top: auto;\n" +
                    "    opacity: 1;\n" +
                    "    width: 100%;\n" +
                    "    padding: 0;\n" +
                    "    position: relative;\n" +
                    "    text-align: left;\n" +
                    "  }\n" +
                    "  #cssmenu ul ul li {\n" +
                    "    width: 100%;\n" +
                    "  }\n" +
                    "  #cssmenu ul ul li a {\n" +
                    "    width: 100%;\n" +
                    "    box-shadow: none;\n" +
                    "    padding-left: 35px;\n" +
                    "  }\n" +
                    "  #cssmenu ul ul ul li a {\n" +
                    "    padding-left: 45px;\n" +
                    "  }\n" +
                    "  #cssmenu ul ul li:first-child > a,\n" +
                    "  #cssmenu ul ul li:last-child > a {\n" +
                    "    border-radius: 0;\n" +
                    "  }\n" +
                    "  #cssmenu #menu-button::after {\n" +
                    "    display: block;\n" +
                    "    content: '';\n" +
                    "    position: absolute;\n" +
                    "    height: 3px;\n" +
                    "    width: 22px;\n" +
                    "    border-top: 2px solid #fff;\n" +
                    "    border-bottom: 2px solid #fff;\n" +
                    "    right: 25px;\n" +
                    "    top: 18px;\n" +
                    "  }\n" +
                    "  #cssmenu #menu-button::before {\n" +
                    "    display: block;\n" +
                    "    content: '';\n" +
                    "    position: absolute;\n" +
                    "    height: 3px;\n" +
                    "    width: 22px;\n" +
                    "    border-top: 2px solid #fff;\n" +
                    "    right: 25px;\n" +
                    "    top: 28px;\n" +
                    "  }\n" +
                    "  #cssmenu > ul > li.has-sub > a::after,\n" +
                    "  #cssmenu ul ul li.has-sub > a::after {\n" +
                    "    display: none;\n" +
                    "  }\n" +
                    "}\n" +
                    "#cssmenu {\n" +
                    "\n" +
                    " position: static;\n" +
                    "    position: -webkit-sticky;\n" +
                    " position: -moz-sticky;\n" +
                    " position: -ms-sticky;\n" +
                    " position: -o-sticky;\n" +
                    " position: sticky;\n" +
                    " top: 0px;\n" +
                    "}\n" +
                    "\n" +
                    "/*Header*/\n" +
                    "#header {\n" +
                    "    width: 100%;\n" +
                    "    height: 60px;\n" +
                    "    margin: auto;\n" +
                    "    padding: 10px;\n" +
                    "}\n" +
                    "#header-image {\n" +
                    "    width: 50%;\n" +
                    "    height: 60px;\n" +
                    "    float: left;\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " #header-info {\n" +
                    "    margin-left: 50%;\n" +
                    "    height: 60px;\n" +
                    "    padding-right:25px;\n" +
                    "    \n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "#header-info-username {\n" +
                    "    color: #606060;\n" +
                    " text-align: right;\n" +
                    " margin-top: 10px;\n" +
                    " padding-right: 40px;\n" +
                    " font-weight: bold;\n" +
                    " line-height: 0.3;\n" +
                    " \n" +
                    "}\n" +
                    ".header-info-username {\n" +
                    "    position: absolute;\n" +
                    "    top: 18px;\n" +
                    "    right:32px;\n" +
                    "     line-height: 0.3;\n" +
                    "}\n" +
                    "\n" +
                    ".header-info-logout {\n" +
                    "    position: absolute;\n" +
                    "    top: -100%;\n" +
                    "    right: 32px;\n" +
                    "     line-height: 0.3;\n" +
                    "}\n" +
                    "\n" +
                    ".header-info-logout:hover,.header-info-logout:active {\n" +
                    "    text-decoration: underline;\n" +
                    "}\n" +
                    "\n" +
                    "#header-info-arrow-down {\n" +
                    "    width: 9px;\n" +
                    " cursor: pointer;\n" +
                    "    line-height: 0.3;\n" +
                    "    position: absolute;\n" +
                    "    top: 18px;\n" +
                    "    right:20px;\n" +
                    "     color: #606060;\n" +
                    "   \n" +
                    "}\n" +
                    "\n" +
                    "#header-info-arrow-up {\n" +
                    "    display: none;\n" +
                    "    width: 9px;\n" +
                    " cursor: pointer;\n" +
                    "    line-height: 0.3;\n" +
                    "    position: absolute;\n" +
                    "    top: 18px;\n" +
                    "    right:20px;\n" +
                    "     color: #606060;\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "#temp {        \n" +
                    " position: absolute;\n" +
                    "    top: 35px;\n" +
                    "    right: 20px;  \n" +
                    "    height: 12px;   \n" +
                    "    text-decoration: none; \n" +
                    "    text-align: right;\n" +
                    "    line-height: 120%;\n" +
                    "  \n" +
                    "}  \n" +
                    "\n" +
                    "#humid{        \n" +
                    " position: absolute;\n" +
                    "    top: 60px;\n" +
                    "    right: 20px;  \n" +
                    "    height: 12px;   \n" +
                    "    text-decoration: none; \n" +
                    "    text-align: right;\n" +
                    "    line-height: 120%;\n" +
                    "  \n" +
                    "}  \n" +
                    "\n" +
                    "@keyframes alarm{\n" +
                    "    0%{     color: #fff;    }\n" +
                    "    50%{   color: #cf1624;    }\n" +
                    "    \n" +
                    "}\n" +
                    "\n" +
                    "@keyframes notification{\n" +
                    "    0%{     color: #fff;    }\n" +
                    "    50%{   color: #606060;    }\n" +
                    "    \n" +
                    "}\n" +
                    "\n" +
                    "\n");
            fw.close();
            System.out.println("Success writing to " + fileOrd17.toString());


        } catch (Exception e) // Indicates problem creating file
        { // Call configFail() to set the service into fault
            System.out.println("Error writing to " + fileOrd17.toString());
        }

        //You can also create a File Path from an ORD
        BOrd query = getIndexHTML();
        OrdQuery[] queries = query.parse();
        FilePath fp = (FilePath)queries[queries.length - 1];


//Our BIFile object that we will get back
        BIFile myFile = null;

//Wrap our call in a try catch block to handle IO exception
        try
        {
            myFile = BFileSystem.INSTANCE.makeFile(fp);

            //manipulate new file ...

        }catch(IOException ioe)
        {
            //handle error
        }
//use an ORD to retrieve our file
        BOrd fileQuery =  BOrd.make("module://nTools/html5/html/index.html");

//use a try catch block in case the file doesn't exist
        try
        {
            //if we are executing this code from a component in the station,
            //we can resolve our query using the this keyword
            BIFile myFile3 = (BIFile)fileQuery.get(this);

            //create an input stream reader from the file input stream
            InputStreamReader in = new InputStreamReader( myFile3.getInputStream() );

            //create a try/finally block to force input stream is always closed.
            try
            {
                //use the input stream and create a buffered reader to read
                //each line
                BufferedReader bin = new BufferedReader( in );

                String str;
                while( ( str = bin.readLine() ) != null )
                {


                    //You can also create a File Path from an ORD
                    BOrd myFileOrd = getIndexHTML();

                    //use a try catch block in case the file doesn't exist
                    try
                    {

                        String str2 = str.replace("homePagePath", homePagePath).replace("logoPath", logoPath).replace("historiesMenu",historiesMenu).replace("schedulesMenu",schedulesMenu).replace("reportMenu",reportMenu).replace("docMenu",docMenu).replace("notificationMenu",notificationMenu).replace("alarmMenu",alarmMenu).replace("entSecMenu",entSecMenu);









                        //if we are executing this code from a component in the station,
                        //we can resolve our query using the this keyword
                        BIFile myFile2 = (BIFile)myFileOrd.get(this);

                        FilePath filePath = myFile2.getFilePath();
                        File localFile22 = BFileSystem.INSTANCE.pathToLocalFile(filePath);

                        FileWriter fw = new FileWriter(localFile22,true);
                        fw.write(str2 + "\n");
                        fw.close();
                    }
                    //handle case where file isn't found or doesn't exist.
                    catch(UnresolvedException re)
                    {

                    }
                    //handle IO exceptions from trying to write to the file
                    catch(IOException ioe)
                    {

                    }

                }

            }
            //make sure to close the input stream
            finally
            {
                in.close();
            }

        }
//handle case where file isn't found or doesn't exist.
        catch(UnresolvedException re)
        {

        }
//handle IO exceptions from trying to read from file
        catch(IOException ioe)
        {

        }



        System.out.println("HTML Generation completed at: " + date);
        String currentDate = date.toString();
        setHtmlLastGenerated(currentDate);

    }

    @Override
    public BIcon getIcon() {
        return BIcon.make("module://nTools/icons/html.png");
    }
}








