package br.univali.visao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.univali.model.minimos_quadrados.Point;

/**
 *
 * @author AlissonSteffens
 */
public class JGraph {
    
    private List<Point> points;
    private List<Point> calculatedPoints;

    public JGraph(List<Point> points, List<Point> calculatedPoints) {
        this.points =points;
        this.calculatedPoints=calculatedPoints;
    }

    public void showHTML() throws Exception {
        Map<String, List> map1 = new HashMap<>();
                
        List<Map<String,String>> entrada = new ArrayList<>();
        
        for(int i=0;i<this.points.size(); i++)
        {
            Map<String,String> pontosEntrada= new HashMap<>();
            pontosEntrada.put("x", this.points.get(i).getX().toString());
            pontosEntrada.put("y", this.points.get(i).getY().toString());
            
            entrada.add(pontosEntrada);
        }
        
        List<Map<String,String>> saida = new ArrayList<>();
        
        for(int i=0;i<this.calculatedPoints.size(); i++)
        {
            Map<String,String> pontosSaida= new HashMap<>();
            pontosSaida.put("x", this.calculatedPoints.get(i).getX().toString());
            pontosSaida.put("y", this.calculatedPoints.get(i).getY().toString());
            
            saida.add(pontosSaida);
        }
        
         map1.put("dados", entrada);
         map1.put("calculados", saida);
         
         Gson gson= new GsonBuilder().setPrettyPrinting().create();
         String code = gson.toJson(map1);
         
         String html=lerHtml("./src/template/template.html");
         
         File pastaTemp = new File("./src/template");
         File arquivoHtml = getRelatorio();
         File arquivoLog = getJsLog();
         
         html = html.replace("href=\"./", "href=\"file:///"+ getCaminhoCompleto(pastaTemp) +"/");
         html = html.replace("src=\"./log.js\"", "src=\"file:///"+ getCaminhoCompleto(arquivoLog) + "\"");
         html = html.replace("src=\"./", "src=\"file:///"+ getCaminhoCompleto(pastaTemp) + "/");
         
         
         gravarArquivo(arquivoLog, "var log = " + code + ";");
         gravarArquivo(arquivoHtml, html);
         
         Desktop.getDesktop().open(arquivoHtml);
         
    }
    
    private String lerHtml(String arquivo) throws Exception
    {
        BufferedReader br= new BufferedReader(new FileReader(new File(arquivo)));
        StringBuilder sb= new StringBuilder();
        String linha=null;
        while((linha=br.readLine())!= null)
        {
            sb.append(linha);
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private void gravarArquivo(File arquivo, String conteudo) throws Exception
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
        bw.write(conteudo);
        bw.close();
    }
    
    private String getCaminhoCompleto(File arquivo)
    {       
        try
        {
            return arquivo.getCanonicalPath().replace("\\", "/");
        }
        catch(IOException ex)
        {
            return arquivo.getAbsolutePath().replace("\\", "/");
        }
    }
    
    private File getTempFolder()
    {
        File pasta=new File(System.getProperty("user.home", "./"), ".backupSystem");
        pasta.mkdirs();
        return pasta;
    }
    
    private File getJsLog()
    {
        return new File(getTempFolder(), "log" + System.currentTimeMillis() + ".js");
    }
    
    private File getRelatorio()
    {
        return new File(getTempFolder(), "relatorio" + System.currentTimeMillis() + ".html");
    }
    
}
