export class Task {
    constructor(
       public id: Number,
       public quoteNumber:Number,
       public quoteName:String,
       public contact:String,
       public task: String,
       public tasktype:String,
       public duedate: Date
    ) {}
 }