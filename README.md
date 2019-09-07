# RecyclerViewWithGridLinearWithInSearchItemClcikShow

           Recycler View Step by Step
## 1.	Recycler view declare.

## 2.	Array String data text with image set.

## 3.	Important MyAdapter class create.

## 4.	MyAdapter extends RecyclerView.Adapter<MyViewHolder>

## 5.	MyViewHolder class create korte hobe, then extends korte hobe viewHolder class ke. Then alt+enter declare

## 6.	MyAdapter RecyclerView with alt+enter.

## 7.	Adapter class er theke data gulo pathate hobe, e jonno amar main activity te string array gulo declare korte hobe.
## 8.	Data receive korar jonno mechanison gulo 
// data receive korar jonno macanosiam.
Context context;
String[] proTitle ;
String[] proDesc ;
int[] images;

## 9.	MainActivity  tekhe  ebar Data  pathate  hobe. Aki formate, MyAdapter er akta variable lagbe. 

myAdapter = new MyAdapter(this,proTitle,proDesc,images);


## 10.	Data gulo chole esese myAdapter a ebar ei data gulo niye amra akta sample_view create korbo.

## 11.	 Adapter a ashbo , MyViewHolder a amar simple view convert korbo.

## 12.	Layout inflater er akta object create korbo, inflater.  With context ta pass koriye dibo.

## 13.	Inflater er dara inflate korbo sample view , viewgroup, false.

## 14.	Then inflater j kaj ta korbo akta View return korbe, a rami view object er moddhe rakhbo.

## 15.	MyViewHolder ti muloto ViewHolder class er akta object.

## 16.	viewHolder use kori , karon akta single view ke hold korbe.  

17.	View take return kore dile chole jabe  viewHolder class er kase, r seta extends korbe MyViewHolder class.

Jehetu view ta 

 return new MyViewHolder(view);

 return kore disi and chole ashes viewHolder er moddhe,  extends korse myViewHolder k . akon ekhane sokon data ashes parameter item view er moddhe.  
Akhon, ItemView er moddhe amara item view ke niye data gulo find korte parbo.

18.	Data find kora sesh, data set korte hole amake jete hobe onBind ViewHolder er moddhe.

19 .  onBindViewHolder er moddhe amara data gulo set korte parbo.   myViewHolder er object er madhome  call korbo textView ke er setText method ke call korbo. Then parameter dibo amar constructer er assign kora textView then tar position diye dibo.. 

myViewHolder.titleTv.setText(proTitle[position]) 

19.	getItemCount() – j kono akta array er length diye dibo.

20.	recyClerView.setAdapter(myAdapter);

21.	recyclerview.setLayoutManager(LinearLayoutManager and context diye dibo, this)

Recycler view Listner Adding.

1.	At first MyAdapter class a chole ashbo. With ekhane j ViewHolder class ti ke extends korsilam, sekhane ami duita interface implement korbo. 
#OnClickListner.
#OnLongClcikListner.
Then alt+enter method implement.

2.	Item view er sathe ei duita listener set kore dibo. 
# SetOnClickListenr(this);
# SetOnLongClcikListner(this);

3.	Interface make kore nibo, 
Private static ClickListner clickListner with sobar nise eta use korbo.
// 2 ta method create kore nilam.
void onItemClcik(int position, View view);
void onItemLongClcik(int positin, View view);


4.	Public void setOnItemClickListenr make kore nibo. Jeta muloto amara main activity theke call korbo. J interface make korsi clickListner ei variable dara interface take ami receive korbo.

5.	Amara j class a asi MyAdapter.ClcikListner and user jeta pthabe MainActivity tekhe setake amara receive korbo..

6.	MyAdapter.clcikListner = clcikListner. 
Ei clcikListner holo private static clickListner declare kora seta. = second clickListner holo eta amader manin activity theke receive korete hobe eijonno.

7.	MainActivity theke listener ta set kore dibo. maAdapter er sathe.
8.	MainActivity theke ei gula access korar jonno ei listener gulor help niyesi.
9.	Listner take inter face er madhome set kore diyesi. Method gulo call diyesi. OnItem and OnItemLongClcik okey.

10.	Akon amra saisi amader j position ta click hobe sei position ta return korte.
11 j variable er madhoem kaj ta korobo seta holo click listener.

11.	List view er moton automatic onITem click listener make korte parbona ei jonno amara eta make kore nieyesi. 

12.	 Seta kivabe, akta interface make kore niyesi, sei interface er moddhe at first amara click listener ta receive kore nibo mainActivity theke. Tai seta initialize kore nieyesi. 

13.	Interface a 02 ta method use kore niyesi onITemClick, onItemLongClcik. 

14.	Erpor amara setake adapter er sathe set kore diyesi. And ekhan theke interface pass kore diyesi. Sathe sathe 2 ta method chole ashbe jamon ta amara koresi interface er moddhe..   and ekhane j kaj ta amra korsi onClick, onLongClick.  

15.	 onClcik, onLongClick a jokon click korbe ekhaner theke position and view ta return korbe.

16.	Must item view er sathe listener gulo add kore dite hobe. Implements kore nite hobe 2 ta method. onClcik, onLongClick.
