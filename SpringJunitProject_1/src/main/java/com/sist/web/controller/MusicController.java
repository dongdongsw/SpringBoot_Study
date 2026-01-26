package com.sist.web.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MovieVO;
import com.sist.web.vo.MusicVO;

import lombok.RequiredArgsConstructor;
/*
 * [{"snippet":
 * 		{
 * 		"publishTime":"2021-12-15T14:21:44Z",
 * 		"publishedAt":"2021-12-15T14:21:44Z",
 * 		"description":"Title\u201D by Meghan Trainor Listen to Meghan Trainor: https:\/\/MeghanTrainor.lnk.to\/listenYD Watch more Meghan Trainor videos: ...",
 * 		"title":"Meghan Trainor - Title (Official Music Video)",
 * 		"thumbnails":{"default":
 * 				{
 * 				"width":120,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/default.jpg","height":90},
 * 				"high":{
 * 					"width":480,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/hqdefault.jpg","height":360
 * 				},
 * 				"medium":{
 * 					"width":320,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/mqdefault.jpg","height":180}
 * 				},
 * 				"channelId":"UCf3cbfAXgPFL6OywH7JwOzA","channelTitle":"MeghanTrainorVEVO","liveBroadcastContent":"none"},
 * 				"kind":"youtube#searchResult",
 * 				"etag":"0MecTDDyb4grJJbu-L-kJ-0kLpk",
 * 				"id":
 * 					{
 * 						"kind":"youtube#video","videoId":"fD7LIqkKisc"}},
 */
@Controller
@RequiredArgsConstructor
public class MusicController {

	private final MusicService mService;
	
	@GetMapping("/")
	public String music_list(
			@RequestParam(name = "page", required = false) String page,
			Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		List<MusicVO> list = mService.musicListData((curpage-1)*20);
		int totalpage = mService.musicTotalPage();
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String music_detail(
			Model model,
			@RequestParam("no") int no
			) throws Exception{
		
		String title = mService.musicGetTitle(no);
		//System.out.println("title = " + title);
		
		URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q="+URLEncoder.encode(title,"UTF-8")+"&type=video&key=AIzaSyDXjryVEBzNMR86WA1TTRhZNhPQmD-0nnY");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		StringBuffer sb = new StringBuffer();
		if(conn!=null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			
			
			while(true) {
				String json = in.readLine();
				if(json == null) {
					break;
				}
				sb.append(json);
				//System.out.println(json);
			}
			conn.disconnect();
			in.close();
			//System.out.println(sb.toString());
		}
		//Document doc = Jsoup.connect("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q="+ title +"&type=video&key=AIzaSyDXjryVEBzNMR86WA1TTRhZNhPQmD-0nnY").ignoreContentType(true).get();
		//System.out.println(doc.text());
		
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject)jp.parse(sb.toString());
		//System.out.println(root.toJSONString());
		JSONArray arr = (JSONArray)root.get("items");
		//System.out.println(arr.toJSONString());
		List<MovieVO> list = new ArrayList<MovieVO>();
		for(int i = 0; i < arr.size(); i++) {
			JSONObject obj = (JSONObject)arr.get(i);
			JSONObject snippet = (JSONObject)obj.get("snippet");
			String name = (String)snippet.get("title");
			//System.out.println(name);
			JSONObject id = (JSONObject)obj.get("id");
			String key = (String)id.get("videoId");
			
			MovieVO vo = new MovieVO();
			vo.setTitle(title);
			vo.setKey(key);
			list.add(vo);
			
			model.addAttribute("list",list);
		
		}
		//System.out.println(arr.toJSONString());
			
		//model.addAttribute("json",root.toJSONString());
				
		
		return "detail";
	}
	
}
