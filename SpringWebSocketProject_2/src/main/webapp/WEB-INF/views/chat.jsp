<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}

.row{
	margin:0px auto;
	width: 600px;
}
.h3{
	text-align: center;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row" id="chat">
			<h3>1:1 채팅</h3>
			<table class="table">
				<tbody>
					<tr>
						<td> <!--  width="85%" class="text-left" -->
							<input type="text" v-model="store.userId" ref="userId" placeholder="아이디" class="input-sm">
							<button @click="store.connect()">접속</button>
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" v-model="store.receiver" ref="receiver" placeholder="상대방" class="input-sm">
							
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" v-model="store.msg" ref="msg" placeholder="보낼 메시지" class="input-sm" size="50">
						</td>
					</tr>
					<tr>
						<td>
							<button @click="store.send()">전송</button>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<ul >
								<li v-for="(m,i) in store.message" :key="i">
									{{m.sender}}:{{m.message}}
								</li>
							</ul>
						</td>
					</tr>
				</tbody>
			</table>
			
		</div>
	</div>
	<script src="/js/chatStore.js"></script>
	<script>
		const {createApp, onMounted,ref} = Vue
		const {createPinia} = Pinia

		const chatApp = createApp({
			setup(){
				const store = useChatStore()
				
				/* const userId = ref('')
				const receiver = ref('')
				const msg = ref('') */
				
				/* const connect=()=>{
					store.connect(store.userId)
				}
				
				const send=()=>{
					store.sendPrivateMessage(store.receiver,store.msg)
					store.msg = ''
					
				} */
				
				return{
					store/* 
					userId,
					receiver,
					msg */
					

				}
			}
			
		})
		chatApp.use(createPinia())
		chatApp.mount("#chat")
	</script>
</body>
</html>