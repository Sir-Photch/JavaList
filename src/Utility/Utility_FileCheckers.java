package Utility;

/**
 * Class that evaluates given Path-Strings for types
 *
 * @see <a href="https://fileinfo.com/filetypes/common">fileinfo.com</a>
 */
abstract class Utility_FileCheckers {

    static boolean isTextFile(String file) {
        return file.endsWith(".doc") || file.endsWith(".DOC") ||
                file.endsWith(".docx") || file.endsWith(".DOCX") ||
                file.endsWith(".log") || file.endsWith(".LOG") ||
                file.endsWith(".msg") || file.endsWith(".MSG") ||
                file.endsWith(".odt") || file.endsWith(".ODT") ||
                file.endsWith(".pages") || file.endsWith(".PAGES") ||
                file.endsWith(".rtf") || file.endsWith(".RTF") ||
                file.endsWith(".tex") || file.endsWith(".TEX") ||
                file.endsWith(".txt") || file.endsWith(".TXT") ||
                file.endsWith(".wpd") || file.endsWith(".WPD") ||
                file.endsWith(".wps") || file.endsWith(".WPS") ||
                file.endsWith(".md") || file.endsWith(".MD") ||
                file.endsWith(".pdf") || file.endsWith(".PDF");
    }

    static boolean isDataFile(String file) {
        return file.endsWith(".csv") || file.endsWith(".CSV") ||
                file.endsWith(".dat") || file.endsWith(".DAT") ||
                file.endsWith(".ged") || file.endsWith(".GED") ||
                file.endsWith(".key") || file.endsWith(".KEY") ||
                file.endsWith(".keychain") || file.endsWith(".KEYCHAIN") ||
                file.endsWith(".pps") || file.endsWith(".PPS") ||
                file.endsWith(".ppt") || file.endsWith(".PPT") ||
                file.endsWith(".pptx") || file.endsWith(".PPTX") ||
                file.endsWith(".sdf") || file.endsWith(".SDF") ||
                file.endsWith(".tar") || file.endsWith(".TAR") ||
                file.endsWith(".vcf") || file.endsWith(".VCF") ||
                file.endsWith(".xml") || file.endsWith(".XML") ||
                file.endsWith(".yml") || file.endsWith(".YML");
    }

    static boolean isAudioFile(String file) {
        return file.endsWith(".aif") || file.endsWith(".AIF") ||
                file.endsWith(".iff") || file.endsWith(".IFF") ||
                file.endsWith(".m3u") || file.endsWith(".M3U") ||
                file.endsWith(".m4a") || file.endsWith(".M4A") ||
                file.endsWith(".mid") || file.endsWith(".MID") ||
                file.endsWith(".mp3") || file.endsWith(".MP3") ||
                file.endsWith(".mpa") || file.endsWith(".MPA") ||
                file.endsWith(".wav") || file.endsWith(".WAV") ||
                file.endsWith(".wma") || file.endsWith(".WMA");
    }

    static boolean isVideoFile(String file) {
        return file.endsWith(".3g2") || file.endsWith(".3G2") ||
                file.endsWith(".3gp") || file.endsWith(".3GP") ||
                file.endsWith(".asf") || file.endsWith(".ASF") ||
                file.endsWith(".avi") || file.endsWith(".AVI") ||
                file.endsWith(".flv") || file.endsWith(".FLV") ||
                file.endsWith(".m4v") || file.endsWith(".M4V") ||
                file.endsWith(".mov") || file.endsWith(".MOV") ||
                file.endsWith(".mp4") || file.endsWith(".MP4") ||
                file.endsWith(".mpg") || file.endsWith(".MPG") ||
                file.endsWith(".rm") || file.endsWith(".RM") ||
                file.endsWith(".srt") || file.endsWith(".SRT") ||
                file.endsWith(".swf") || file.endsWith(".SWF") ||
                file.endsWith(".vob") || file.endsWith(".VOB") ||
                file.endsWith(".wmv") || file.endsWith(".WMV");
    }

    static boolean isImageFile(String file) {
        return file.endsWith(".bmp") || file.endsWith(".BMP") ||
                file.endsWith(".dds") || file.endsWith(".DDS") ||
                file.endsWith(".gif") || file.endsWith(".GIF") ||
                file.endsWith(".heic") || file.endsWith(".HEIC") ||
                file.endsWith(".jpg") || file.endsWith(".JPG") ||
                file.endsWith(".jpeg") || file.endsWith(".JPEG") ||
                file.endsWith(".png") || file.endsWith(".PNG") ||
                file.endsWith(".psd") || file.endsWith(".PSD") ||
                file.endsWith(".pspimage") || file.endsWith(".PSPIMAGE") ||
                file.endsWith(".tga") || file.endsWith(".TGA") ||
                file.endsWith(".thm") || file.endsWith(".THM") ||
                file.endsWith(".tif") || file.endsWith(".TIF") ||
                file.endsWith(".tiff") || file.endsWith(".TIFF") ||
                file.endsWith(".yuv") || file.endsWith(".YUV") ||
                file.endsWith(".ai") || file.endsWith(".AI") ||
                file.endsWith(".eps") || file.endsWith(".EPS") ||
                file.endsWith(".ps") || file.endsWith(".PS") ||
                file.endsWith(".svg") || file.endsWith(".SVG");
    }

    static boolean isSpreadsheetFile(String file) {
        return file.contains(".xlr") || file.contains(".XLR") ||
                file.contains(".xls") || file.contains(".XLS") ||
                file.contains(".xlsx") || file.contains(".XLSX");
    }

    static boolean isDatabaseFile(String file) {
        return file.endsWith(".accdb") || file.endsWith(".ACCDB") ||
                file.endsWith(".db") || file.endsWith(".DB") ||
                file.endsWith(".dbf") || file.endsWith(".DBF") ||
                file.endsWith(".mdb") || file.endsWith(".MDB") ||
                file.endsWith(".pdb") || file.endsWith(".PDB") ||
                file.endsWith(".sql") || file.endsWith(".SQL");
    }

    static boolean isExecutable(String file) {
        return file.endsWith(".apk") || file.endsWith(".APK") ||
                file.endsWith(".app") || file.endsWith(".APP") ||
                file.endsWith(".bat") || file.endsWith(".BAT") ||
                file.endsWith(".cgi") || file.endsWith(".CGI") ||
                file.endsWith(".com") || file.endsWith(".COM") ||
                file.endsWith(".exe") || file.endsWith(".EXE") ||
                file.endsWith(".gadget") || file.endsWith(".GADGET") ||
                file.endsWith(".jar") || file.endsWith(".JAR") ||
                file.endsWith(".wsf") || file.endsWith(".WSF");
    }

    static boolean isWebFile(String file) {
        return file.endsWith(".asp") || file.endsWith(".ASP") ||
                file.endsWith(".aspx") || file.endsWith(".ASPX") ||
                file.endsWith(".cer") || file.endsWith(".CER") ||
                file.endsWith(".cfm") || file.endsWith(".CFM") ||
                file.endsWith(".csr") || file.endsWith(".CSR") ||
                file.endsWith(".css") || file.endsWith(".CSS") ||
                file.endsWith(".dcr") || file.endsWith(".DCR") ||
                file.endsWith(".htm") || file.endsWith(".HTM") ||
                file.endsWith(".html") || file.endsWith(".HTML") ||
                file.endsWith(".js") || file.endsWith(".JS") ||
                file.endsWith(".json") || file.endsWith(".JSON") ||
                file.endsWith(".jsp") || file.endsWith(".JSP") ||
                file.endsWith(".php") || file.endsWith(".PHP") ||
                file.endsWith(".rss") || file.endsWith(".RSS") ||
                file.endsWith(".xhtml") || file.endsWith(".XHTML");
    }

    static boolean isSystemFile(String file) {
        return file.endsWith(".cab") || file.endsWith(".CAB") ||
                file.endsWith(".cpl") || file.endsWith(".CPL") ||
                file.endsWith(".cur") || file.endsWith(".CUR") ||
                file.endsWith(".deskthemepack") || file.endsWith(".DESKTHEMEPACK") ||
                file.endsWith(".dll") || file.endsWith(".DLL") ||
                file.endsWith(".dmp") || file.endsWith(".DMP") ||
                file.endsWith(".drv") || file.endsWith(".DRV") ||
                file.endsWith(".icns") || file.endsWith(".ICNS") ||
                file.endsWith(".ico") || file.endsWith(".ICO") ||
                file.endsWith(".lnk") || file.endsWith(".LNK") ||
                file.endsWith(".sys") || file.endsWith(".SYS");
    }

    static boolean isCompressedFile(String file) {
        return file.endsWith(".7z") || file.endsWith(".7Z") ||
                file.endsWith(".cbr") || file.endsWith(".CBR") ||
                file.endsWith(".deb") || file.endsWith(".DEB") ||
                file.endsWith(".gz") || file.endsWith(".GZ") ||
                file.endsWith(".pkg") || file.endsWith(".PKG") ||
                file.endsWith(".rar") || file.endsWith(".RAR") ||
                file.endsWith(".rpm") || file.endsWith(".RPM") ||
                file.endsWith(".sitx") || file.endsWith(".SITX") ||
                file.endsWith(".tar.gz") || file.endsWith(".TAR.GZ") ||
                file.endsWith(".zip") || file.endsWith(".ZIP") ||
                file.endsWith(".zipx") || file.endsWith(".ZIPX");
    }

    static boolean isDiskImageFile(String file) {
        return file.endsWith(".bin") || file.endsWith(".BIN") ||
                file.endsWith(".cue") || file.endsWith(".CUE") ||
                file.endsWith(".dmg") || file.endsWith(".DMG") ||
                file.endsWith(".iso") || file.endsWith(".ISO") ||
                file.endsWith(".mdf") || file.endsWith(".MDF") ||
                file.endsWith(".toast") || file.endsWith(".TOAST") ||
                file.endsWith(".vcd") || file.endsWith(".VCD");
    }

    static boolean isDeveloperFile(String file) {
        return file.endsWith(".c") || file.endsWith(".C") ||
                file.endsWith(".class") || file.endsWith(".CLASS") ||
                file.endsWith(".cpp") || file.endsWith(".CPP") ||
                file.endsWith(".cs") || file.endsWith(".CS") ||
                file.endsWith(".dtd") || file.endsWith(".DTD") ||
                file.endsWith(".fla") || file.endsWith(".FLA") ||
                file.endsWith(".h") || file.endsWith(".H") ||
                file.endsWith(".java") || file.endsWith(".JAVA") ||
                file.endsWith(".lua") || file.endsWith(".LUA") ||
                file.endsWith(".m") || file.endsWith(".M") ||
                file.endsWith(".pl") || file.endsWith(".PL") ||
                file.endsWith(".py") || file.endsWith(".PY") ||
                file.endsWith(".sh") || file.endsWith(".SH") ||
                file.endsWith(".sln") || file.endsWith(".SLN") ||
                file.endsWith(".swift") || file.endsWith(".SWIFT") ||
                file.endsWith(".vb") || file.endsWith(".VB") ||
                file.endsWith(".vcxproj") || file.endsWith(".VCXPROJ") ||
                file.endsWith(".xcodeproj") || file.endsWith(".XCODEPROJ");
    }
}
