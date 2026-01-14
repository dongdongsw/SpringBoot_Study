<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin:0px auto;
	width: 500px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 20px;">
			<h3 class="text-center">Vue를 이용한 파일 업로드</h3>
			<input type="file" size="20"  style="float: left;" multiple @change="handlerFile">
			<button type="button" style="float: left;" @click="submit">등록</button>
		</div>
		
		<div class="row">
			<h3 class="text-center">단일 파일 업로드</h3>
			파일 : <input type="file" size="20"  style="float: left;">
			<button type="button" style="float: left;">업로드</button>
		</div>
	</div>
	
	<script>
		const app = Vue.createApp({
			data(){
				return{
					files:[]
				}
			},
			methods:{
				handlerFile(e){
					this.files = e.target.files
					console.log(this.files)
				},
				submit(){
					const formData = new FormData()
					for(let i of this.files){
						formData.append('files',i)
					}
					console.log(formData)
					axios.post('/multi_upload',formData,{
						headers:{
							'Content-Type' : 'multipart/form-data'
						}
					}).then(()=>alert("등록 완료"))
				}
				
			}
		}).mount(".container")
	</script>
</body>
</html>