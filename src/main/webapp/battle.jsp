<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TakataRPG</title>
</head>
<body>
	<div style="float: left;">
		<div class="enemy" >
			<ul style="list-style: none;">
				<li><img id="enemy" src="img/fantasy_game_character_slime.png"
					width="150px" height="150px"></li>
				<li><p>${monster.name}</p></li>
				<li><p>HP:${monster.hp}</p></li>
				<li>
				ダメージ：<c:out value="-${mdmg}"/>
				</li>

			</ul>
		</div>
		
		
		
		<div class="user" >

			<ul style="list-style: none;">

				<li><img id="user" src="img/yuusya_game.png" width="150px"
					height="150px"></li>
				<li><p>${yuusha.name}</p></li>
				<li><p>HP:${yuusha.hp}</p></li>
				<li>
				<form action ="/TakataRPG/FrontController" method="post">
				<input type="hidden" name="action" value="attack">
				<input type="submit" value="攻撃">
				
				</form>
				
				</li>
				<li>
				<form action ="/TakataRPG/FrontController" method ="post">
				<input type="hidden" name="action" value="block">
				<input type="submit" value="防御">
				
				</form>
				
				</li>
				<li>
				ダメージ：<c:out value="-${ydmg}"/>
				</li>
			</ul>



		</div>
		

	</div>

</body>
</html>