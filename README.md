# demo-git-Vinid
áp bán vé bóng đá
người dùng cần đăng nhập để mua vé
vé có 3 trang thái: mua, chưa mua và đang thanh toán
khi người dùng đặt vé(vé sẽ và trang thái đang thanh toán người dùng khác không thể mua vé đang trong trang thái này) 
trong vong 5 phut chưa thanh toán thì sẽ bị out khỏi phiên mua vé => vé về trang thái chưa mua!
khi đó người dùng khác sẽ có thể mua vé đó,
khi thanh toán thành công thông tin vé sẽ đc lưu trong book vé,
book vé có 2 trang thái: đã xem va chưa xem,
khi đc check vào sân vé sẽ thành trạng thái đã xem,

Cac bang:
Table users as U {
  id int [pk, increment] // auto-increment
  user_name varchar
  password varchar
  email varchar
  ad int
}

Table book_tickets as B {
  id int [pk]
  ticket_id int [ref: > T.id]
  book_name varchar
  status varchar
  user_id int [ref: > U.id] // inline relationship (many-to-one)
}

Table tickets as T{
  id int[pk]
  match_id int[ref: > M.id]
  ticket_name varchar
  seat varchar
  price int
  time datetime
  stadium_name varchar
  qr varchar
  
}

Table match as M{
  id int[pk]
  name_teama varchar
  name_teamb varchar
  infors varchar
}
